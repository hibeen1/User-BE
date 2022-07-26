package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // All CRUD DB methods
    Optional<User> findByUserId(String userId);
}
