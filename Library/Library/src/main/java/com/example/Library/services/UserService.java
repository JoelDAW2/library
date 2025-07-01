package com.example.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library.models.User;
import com.example.Library.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User createUser(User user){
        return UserRepository.save(user);
    }

    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }
}
