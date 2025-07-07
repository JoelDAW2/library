package com.example.Library.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Library.repositories.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<String> showUsers(@PathVariable Long userId){
        return profileRepository.showUsers(userId);
    }

    public List<String> showProfile(@PathVariable Long userId){
        return profileRepository.showProfile(userId);
    }
}