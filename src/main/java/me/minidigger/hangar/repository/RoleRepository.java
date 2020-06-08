package me.minidigger.hangar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.Role;

@Repository
@RepositoryRestResource(exported = false)
public interface RoleRepository extends CrudRepository<Role, UUID> {

    Optional<Role> findByName(String name);

}
