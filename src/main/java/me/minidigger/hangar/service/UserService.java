package me.minidigger.hangar.service;

import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import me.minidigger.hangar.model.Role;
import me.minidigger.hangar.model.SpringUser;
import me.minidigger.hangar.model.User;
import me.minidigger.hangar.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    private Set<UUID> loggedOut = new HashSet<>();

    @Autowired
    public UserService(UserRepository repository, TokenService tokenService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return repository.findById(id);
    }

    public User addUser(String username, String email, String password) {
        return repository.save(new User(username, email, passwordEncoder.encode(password)));
    }

    public void deleteUserById(UUID id) {
        repository.deleteById(id);
    }

    public Optional<SpringUser> findByToken(String token) {
        try {
            DecodedJWT jwt = tokenService.verify(token);
            UUID uuid = UUID.fromString(jwt.getSubject());
            if (loggedOut.contains(uuid)) return Optional.empty();
            return getUserById(uuid).map(this::getSpringUser);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Optional<User> grantRole(UUID id, String roleName) {
        Optional<User> user = getUserById(id);
        if (user.isPresent()) {
            Optional<Role> role = roleService.getRoleByName(roleName);
            if (role.isEmpty()) {
                role = Optional.of(roleService.addRole(new Role(roleName)));
            }

            user.get().getRoles().add(role.get());
        }
        return user;
    }

    public Optional<String> login(String username, String password) {
        Optional<User> optUser = repository
                .findByUsername(username);
        Optional<String> token = optUser
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> tokenService.expiring(user.getId(), user.getRoles().stream().map(Role::getName).collect(Collectors.toList())));

        token.ifPresent((s) -> loggedOut.remove(optUser.get().getId()));

        return token;
    }

    // jaja, I know this is dum, but good enough for now
    public void logout(User user) {
        loggedOut.add(user.getId());
    }

    private SpringUser getSpringUser(User user) {
        return new SpringUser(user);
    }
}
