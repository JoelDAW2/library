package com.example.Library.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.services.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService listProfileService;
    
    @GetMapping("/all/{userId}")
    public List<String> showUsers(@PathVariable Long userId) {
        return listProfileService.showUsers(userId);
    }
    
    @GetMapping("/{userId}")
    public List<String> showProfile(@PathVariable Long userId){
        return listProfileService.showProfile(userId);
    }
}