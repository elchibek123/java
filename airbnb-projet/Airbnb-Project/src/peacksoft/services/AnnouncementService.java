package peacksoft.services;

import peacksoft.models.Announcement;

import java.util.List;

public interface AnnouncementService {
    String save(Long userId, Announcement announcement);

    List<Announcement> getAnnouncementsByUserId(Long userId);

    List<Announcement> getAllAnnouncements();
}
