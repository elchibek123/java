package peacksoft.services.impl;

import peacksoft.dao.impl.AnnouncementDaoImpl;
import peacksoft.dao.impl.UserDaoImpl;
import peacksoft.exceptions.NotFoundException;
import peacksoft.models.Announcement;
import peacksoft.models.User;
import peacksoft.services.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementDaoImpl announcementDao;
    private final UserDaoImpl userDao;

    public AnnouncementServiceImpl(AnnouncementDaoImpl announcementDao, UserDaoImpl userDao) {
        this.announcementDao = announcementDao;
        this.userDao = userDao;
    }

    @Override
    public String save(Long userId, Announcement announcement) {
        User foundUser;
        try {
            foundUser = userDao.findById(userId);
        } catch (NotFoundException e) {
            return e.getMessage();
        }
        announcement.setOwner(foundUser);
        announcementDao.save(announcement);
        System.out.println(announcement.getOwner());
        return "Successfully saved";
    }

    @Override
    public List<Announcement> getAnnouncementsByUserId(Long userId) {
        return announcementDao.getAnnouncementsByUserId(userId);
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementDao.getAllAnnouncements();
    }
}
