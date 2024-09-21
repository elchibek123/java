package peacksoft.dao;

import peacksoft.models.Announcement;

import java.util.List;

public interface AnnouncementDao {
    void save(Announcement announcement);

    List<Announcement> getAnnouncementsByUserId(Long userId);

    List<Announcement> getAllAnnouncements();
}
