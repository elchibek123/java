package peacksoft.dao.impl;

import peacksoft.dao.AnnouncementDao;
import peacksoft.dao.CustomDao;
import peacksoft.database.Database;
import peacksoft.exceptions.NotFoundException;
import peacksoft.models.Announcement;
import peacksoft.models.idGenerator;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao, CustomDao<Announcement, Long> {
    private final Database database;

    public AnnouncementDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void save(Announcement announcement) {
        announcement.setId(idGenerator.getAnnouncementId());
        database.announcements.add(announcement);
    }

    @Override
    public Announcement findById(Long id) {
        for (Announcement announcement : database.announcements) {
            if (announcement.getId().equals(id)) {
                return announcement;
            }
        }
        throw new NotFoundException("Announcement with id: " + id + " not found");
    }

    @Override
    public List<Announcement> findAll() {
        return database.announcements;
    }

    @Override
    public List<Announcement> getAnnouncementsByUserId(Long userId) {
        List<Announcement> userAnnouncements = new ArrayList<>();
        for (Announcement announcement : database.announcements) {
            if (announcement.getOwner().getId().equals(userId)) {
                userAnnouncements.add(announcement);
            }
        }
        return userAnnouncements;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return database.announcements;
    }
}
