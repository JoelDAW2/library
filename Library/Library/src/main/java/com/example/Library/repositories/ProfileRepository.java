package com.example.Library.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Library.models.User;

public interface ProfileRepository extends JpaRepository<User, Long>{
    @Query("Select u.username,b.title,r.score,r.comment from Review r left join Book b on b.id = r.bookId inner join User u on u.id = r.userId WHERE not r.userId = :userId order by u.username")
    List<String> showUsers(@Param("userId") Long userId);
    
    @Query("Select b.title,r.score,r.comment from Review r left join Book b on b.id = r.bookId inner join User u on u.id = r.userId WHERE r.userId = :userId order by u.username")
    List<String> showProfile(@Param("userId") Long userId);
}