package peacksoft.dao.impl;

import peacksoft.dao.CustomDao;
import peacksoft.dao.UserDao;
import peacksoft.database.Database;
import peacksoft.exceptions.NotFoundException;
import peacksoft.models.Favorite;
import peacksoft.models.User;
import peacksoft.models.idGenerator;

import java.util.List;

public class UserDaoImpl implements UserDao, CustomDao<User, Long> {
    private final Database database;

    public UserDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void save(User user) {
        user.setId(idGenerator.getUserId());
        Favorite favorite = new Favorite();
        favorite.setId(idGenerator.getFavoriteId());
        user.setFavorite(favorite);
        database.users.add(user);
    }

    @Override
    public User findById(Long id) {
        for (User user : database.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NotFoundException("User with id: " + id + " not found");
    }

    @Override
    public List<User> findAll() {
        return database.users;
    }
}
