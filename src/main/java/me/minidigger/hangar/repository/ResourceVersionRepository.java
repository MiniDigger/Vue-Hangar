package me.minidigger.hangar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import me.minidigger.hangar.model.ResourceVersion;

@Repository
@RepositoryRestResource(exported = false)
public interface ResourceVersionRepository extends CrudRepository<ResourceVersion, UUID> {
}
