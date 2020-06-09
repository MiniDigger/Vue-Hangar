package me.minidigger.hangar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.Announcement;
import me.minidigger.hangar.service.AnnouncementService;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementService service;

    @Autowired
    public AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Iterable<Announcement> getAll() {
        return service.getAllAnnouncements();
    }

    @GetMapping("/{slugOrId}")
    public Optional<Announcement> get(@PathVariable String slugOrId) {
        try {
            return service.getAnnouncementById(UUID.fromString(slugOrId));
        } catch (IllegalArgumentException e) {
            return service.getAnnouncementBySlug(slugOrId);
        }
    }

    @PutMapping("/")
    public Announcement put(@RequestBody Announcement announcement) {
        return service.createAnnouncement(announcement);
    }
}
