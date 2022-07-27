package com.example.springbootbackend.controller;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.User;
import com.example.springbootbackend.repository.UserRepository;
import com.example.springbootbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        return new ResponseEntity<User>(userService.getUserByUserId(userId), HttpStatus.OK);
    }

    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @GetMapping("check-id/{userId}")
    public ResponseEntity<Boolean> checkId(@PathVariable("userId") String userId) {
        return new ResponseEntity<Boolean>(userService.checkIdDuplicated(userId), HttpStatus.OK);
    }

    @GetMapping("check-nickname/{nickname}")
    public ResponseEntity<Boolean> checkNickname(@PathVariable("nickname") String nickname) {
        return new ResponseEntity<Boolean>(userService.checkNicknameDuplicated(nickname), HttpStatus.OK);
    }

}
