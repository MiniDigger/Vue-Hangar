package me.minidigger.hangar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.User;
import me.minidigger.hangar.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return repository.findById(id);
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public void deleteUserById(UUID id) {
        repository.deleteById(id);
    }
}
