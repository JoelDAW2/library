package com.example.Library.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Library.models.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long>{
    User findByUsernameAndPassword(String username, String password);
}
