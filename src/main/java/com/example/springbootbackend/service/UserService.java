package com.example.springbootbackend.service;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User getUserById(long id);
    public List<User> getAllUsers();
    public User updateUser(User user, long id);
    public int deleteUser(long id);
}
