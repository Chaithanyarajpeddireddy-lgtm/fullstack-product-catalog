//package com.catalog.model.mongo;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.context.annotation.Profile;
//
//@Profile("mongo")
//@Document(collection = "users")
//public class User {
//
//    @Id
//    private String id;
//
//    @Indexed(unique = true)
//    private String username;
//
//    private String password;
//    private String role;
//
//    public String getId() { return id; }
//    public void setId(String id) { this.id = id; }
//
//    public String getUsername() { return username; }
//    public void setUsername(String username) { this.username = username; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getRole() { return role; }
//    public void setRole(String role) { this.role = role; }
//}

package com.catalog.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoUser {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private String role;

}