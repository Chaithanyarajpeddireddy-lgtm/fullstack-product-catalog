//package com.catalog.controller.postgres;
//
//import com.catalog.model.User;
//import com.catalog.repository.postgres.UserRepository;
//import com.catalog.service.JwtUtil;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//@Profile("postgres")
//public class AuthController {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtUtil jwtUtil;
//
//    public AuthController(UserRepository userRepository,
//                          PasswordEncoder passwordEncoder,
//                          JwtUtil jwtUtil) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user) {
//        System.out.println("REGISTER HIT [PostgreSQL]");
//
//        if (userRepository.existsByUsername(user.getUsername())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(Map.of("error", "Username already exists"));
//        }
//
//        if (user.getRole() == null ||
//                (!user.getRole().equals("ROLE_ADMIN")
//                        && !user.getRole().equals("ROLE_MANAGER")
//                        && !user.getRole().equals("ROLE_CUSTOMER"))) {
//            return ResponseEntity.badRequest()
//                    .body(Map.of("error", "Role must be ROLE_ADMIN, ROLE_MANAGER, or ROLE_CUSTOMER"));
//        }
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        User saved = userRepository.save(user);
//
//        return ResponseEntity.ok(Map.of(
//                "id", saved.getId(),
//                "username", saved.getUsername(),
//                "role", saved.getRole()
//        ));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        System.out.println("LOGIN HIT [PostgreSQL]");
//
//        User dbUser = userRepository.findByUsername(user.getUsername()).orElse(null);
//
//        if (dbUser == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(Map.of("error", "User not found"));
//        }
//
//        if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid credentials"));
//        }
//
//        String token = jwtUtil.generateToken(dbUser.getUsername());
//
//        return ResponseEntity.ok(Map.of(
//                "id", dbUser.getId(),
//                "token", token,
//                "username", dbUser.getUsername(),
//                "role", dbUser.getRole()
//        ));
//    }
//
//    @GetMapping("/test")
//    public String test() {
//        return "Auth Controller Working [PostgreSQL]";
//    }
//}


package com.catalog.controller.postgres;

import com.catalog.model.postgres.User;
import com.catalog.repository.postgres.UserRepository;
import com.catalog.service.JwtUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Profile("postgres")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        System.out.println("[PostgreSQL] Register: " + body.get("username"));
        if (userRepository.findByUsername(body.get("username")).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User user = new User();
        user.setUsername(body.get("username"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        user.setRole("USER");
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        System.out.println("[PostgreSQL] Login: " + body.get("username"));
        return userRepository.findByUsername(body.get("username"))
                .filter(u -> passwordEncoder.matches(body.get("password"), u.getPassword()))
                .map(u -> ResponseEntity.ok(Map.of(
                        "token", jwtUtil.generateToken(u.getUsername()),
                        "id", u.getId(),
                        "username", u.getUsername(),
                        "role", u.getRole()
                )))
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
    }
}
