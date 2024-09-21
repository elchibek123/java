package peacksoft.dao.impl;

import peacksoft.dao.FavoriteDao;
import peacksoft.database.Database;
import peacksoft.models.Favorite;
import peacksoft.models.idGenerator;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private final Database database;

    public FavoriteDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void save(Favorite favorite) {
        favorite.setId(idGenerator.getFavoriteId());
        database.favorites.add(favorite);
    }

    @Override
    public List<Favorite> getAll() {
        return database.favorites;
    }
}
