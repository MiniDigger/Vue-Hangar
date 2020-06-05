package me.minidigger.hangar.service;

import me.minidigger.hangar.model.Resource;
import me.minidigger.hangar.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ResourceService {

    private final ResourceRepository repository;

    @Autowired
    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public Iterable<Resource> getAllResources() {
        return repository.findAll();
    }

    public Optional<Resource> getResourceById(UUID id) {
        return repository.findById(id);
    }

    public Resource addResource(Resource resource) {
        return repository.save(resource);
    }

    public void deleteResourceById(UUID id) {
        repository.deleteById(id);
    }
}
