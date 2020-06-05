package me.minidigger.hangar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.User;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
