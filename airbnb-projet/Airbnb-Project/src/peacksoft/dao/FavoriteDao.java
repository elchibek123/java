package peacksoft.dao;

import peacksoft.models.Favorite;

import java.util.List;

public interface FavoriteDao {
    void save(Favorite favorite);

    List<Favorite> getAll();
}
