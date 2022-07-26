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
    public User getUserById(long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new ResourceNotFoundException("User", "id", id);
//        }
        return userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, long id) {
        User updateUser = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        updateUser.setName(user.getName());
        updateUser.setNickname(user.getNickname());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        userRepository.save(updateUser);

        return updateUser;
    }

    @Override
    public int deleteUser(long id) {
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
        return 1;
    }
}
