package me.minidigger.hangar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import me.minidigger.hangar.model.User;

@Repository
@RestResource(exported = false)
public interface UserRepository extends CrudRepository<User, UUID> {
}
