package com.example.springbootbackend.service;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.User;
import com.example.springbootbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserId(String userId) {
//        Optional<User> user = userRepository.findByUserId(userId);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new ResourceNotFoundException("User", "id", id);
//        }
        return userRepository.findByUserId(userId).
                orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String userId) {
        User updateUser = userRepository.findByUserId(userId).
                orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        updateUser.setName(user.getName());
        updateUser.setNickname(user.getNickname());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        userRepository.save(updateUser);

        return updateUser;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "userId", userId));
        userRepository.deleteById(user.getUser_seq());
    }
}
