package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // All CRUD DB methods
}
