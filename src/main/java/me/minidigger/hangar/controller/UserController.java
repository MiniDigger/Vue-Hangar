package me.minidigger.hangar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.User;
import me.minidigger.hangar.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Iterable<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }
}
