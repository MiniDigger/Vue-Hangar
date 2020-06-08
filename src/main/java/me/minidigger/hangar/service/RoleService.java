package me.minidigger.hangar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import me.minidigger.hangar.model.Role;
import me.minidigger.hangar.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Optional<Role> getRoleByName(String name) {
        return repository.findByName(name);
    }

    public Role addRole(Role role) {
        return repository.save(role);
    }
}
