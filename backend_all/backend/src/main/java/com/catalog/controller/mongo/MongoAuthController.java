package com.catalog.controller.mongo;

import com.catalog.model.mongo.User;
import com.catalog.repository.mongo.MongoUserRepository;
import com.catalog.service.JwtUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Profile("mongo")
public class MongoAuthController {

    private final MongoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public MongoAuthController(MongoUserRepository userRepository,
                                PasswordEncoder passwordEncoder,
                                JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println("REGISTER HIT [MongoDB]");

        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Username already exists"));
        }

        if (user.getRole() == null ||
                (!user.getRole().equals("ROLE_ADMIN")
                        && !user.getRole().equals("ROLE_MANAGER")
                        && !user.getRole().equals("ROLE_CUSTOMER"))) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Role must be ROLE_ADMIN, ROLE_MANAGER, or ROLE_CUSTOMER"));
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);

        return ResponseEntity.ok(Map.of(
                "id", saved.getId(),
                "username", saved.getUsername(),
                "role", saved.getRole()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println("LOGIN HIT [MongoDB]");

        User dbUser = userRepository.findByUsername(user.getUsername()).orElse(null);

        if (dbUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "User not found"));
        }

        if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid credentials"));
        }

        String token = jwtUtil.generateToken(dbUser.getUsername());

        return ResponseEntity.ok(Map.of(
                "id", dbUser.getId(),
                "token", token,
                "username", dbUser.getUsername(),
                "role", dbUser.getRole()
        ));
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Controller Working [MongoDB]";
    }
}
