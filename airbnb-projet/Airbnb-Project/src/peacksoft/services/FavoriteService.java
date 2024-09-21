package peacksoft.services;

import peacksoft.models.Announcement;
import peacksoft.models.User;

import java.util.List;
import java.util.Map;

public interface FavoriteService {
    void favoriteAnnouncement(Long userId, Long announcementId);

    Map<User, List<Announcement>> getAllFavoriteAnnouncements(Long userId);
}
