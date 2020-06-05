package me.minidigger.hangar.controller;

import me.minidigger.hangar.model.Resource;
import me.minidigger.hangar.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public Iterable<Resource> getAll() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Optional<Resource> get(@PathVariable UUID id) {
        return resourceService.getResourceById(id);
    }

    @PutMapping
    public Resource addResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable UUID id) {
        resourceService.deleteResourceById(id);
    }
}
