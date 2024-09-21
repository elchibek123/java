package peacksoft.services.impl;

import peacksoft.dao.impl.AnnouncementDaoImpl;
import peacksoft.dao.impl.FavoriteDaoImpl;
import peacksoft.dao.impl.UserDaoImpl;
import peacksoft.models.Announcement;
import peacksoft.models.Favorite;
import peacksoft.models.User;
import peacksoft.services.FavoriteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteDaoImpl favoriteDao;
    private final UserDaoImpl userDao;
    private final AnnouncementDaoImpl announcementDao;

    public FavoriteServiceImpl(FavoriteDaoImpl favoriteDao, UserDaoImpl userDao, AnnouncementDaoImpl announcementDao) {
        this.favoriteDao = favoriteDao;
        this.userDao = userDao;
        this.announcementDao = announcementDao;
    }

    @Override
    public void favoriteAnnouncement(Long userId, Long announcementId) {
        try {
            User foundUser = userDao.findById(userId);
            Announcement foundAnnouncement = announcementDao.findById(announcementId);
            Favorite favorite = foundUser.getFavorite();
            favorite.setUser(foundUser);

            if (favorite.getAnnouncements().contains(foundAnnouncement)) {
                favorite.getAnnouncements().remove(foundAnnouncement);
            } else {
                favorite.getAnnouncements().add(foundAnnouncement);
            }

            favoriteDao.save(favorite);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<User, List<Announcement>> getAllFavoriteAnnouncements(Long userId) {
        Map<User, List<Announcement>> userAnnouncementMap = new HashMap<>();
        User userByIe = userDao.findById(userId);
        Favorite favorite = userByIe.getFavorite();
        userAnnouncementMap.put(favorite.getUser(), favorite.getAnnouncements());
        return userAnnouncementMap;
    }
}
