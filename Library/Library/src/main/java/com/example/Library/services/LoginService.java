package com.example.Library.services;

import com.example.Library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;


import com.example.Library.repositories.LoginRepository;


@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;

    public ResponseEntity<String> login(String userName, String password){
        User user = loginRepository.findByUsernameAndPassword(userName, password);
        
        if (user != null) {
            return ResponseEntity.ok(user.getName()); 
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }
}
