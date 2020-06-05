package me.minidigger.hangar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.SpringUser;
import me.minidigger.hangar.model.User;
import me.minidigger.hangar.security.RequiresLogin;
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
    @RequiresLogin
    public Iterable<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @RequiresLogin
    public Optional<User> get(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @RequiresLogin
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") final String username,
            @RequestParam("email") final String email,
            @RequestParam("password") final String password) {
        userService.addUser(username, email, password);

        return login(username, password);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return userService
                .login(username, password)
                .orElseThrow(() -> new BadCredentialsException("invalid login and/or password"));
    }

    @GetMapping("/current")
    @RequiresLogin
    public User getCurrent(@AuthenticationPrincipal final SpringUser user) {
        return user.getUser();
    }

    @GetMapping("/logout")
    @RequiresLogin
    public boolean logout(@AuthenticationPrincipal final SpringUser user) {
        userService.logout(user.getUser());
        return true;
    }
}
