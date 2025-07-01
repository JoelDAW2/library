package com.example.Library.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Library.models.User;
@RestController
@RequestMapping("/api")
public class LoginController {
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // For demonstration, we assume a fixed username and password.
        String fixedUsername = "user";
        String fixedPassword = "password";
        if (fixedUsername.equals(user.getUsername()) &&
            fixedPassword.equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid credentials.");
        }
    }
}