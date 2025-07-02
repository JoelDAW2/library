package com.example.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library.models.User;
import com.example.Library.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null) {
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName);

        if(user != null)
        {
            return user;
        }
        else
        {
            return null;
        }
    }
}
