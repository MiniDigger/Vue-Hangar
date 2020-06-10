package me.minidigger.hangar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import me.minidigger.hangar.model.Announcement;
import me.minidigger.hangar.repository.AnnouncementRepository;

@Service
public class AnnouncementService {

    private final AnnouncementRepository repository;

    @Autowired
    public AnnouncementService(AnnouncementRepository repository) {
        this.repository = repository;
    }

    public Iterable<Announcement> getAllAnnouncements() {
        return this.repository.findAllByOrderByPublishedOnDesc();
    }

    public Optional<Announcement> getAnnouncementById(UUID id) {
        return this.repository.findById(id);
    }

    public Optional<Announcement> getAnnouncementBySlug(String slug) {
        return this.repository.findBySlug(slug);
    }

    public Announcement createAnnouncement(Announcement announcement) {
        return this.repository.save(announcement);
    }
}
