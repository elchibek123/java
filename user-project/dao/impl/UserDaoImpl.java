package java22.dao.impl;

import java22.dao.UserDao;
import java22.db.Database;
import java22.models.User;

import java.util.List;
import java.util.NoSuchElementException;

public class UserDaoImpl implements UserDao<User, Long> {
    @Override
    public void create(User user) {
        if (user.getId() == null || user.getUsername() == null || user.getEmail() == null) {
            throw new NullPointerException();
        }
        Database.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return Database.users;
    }

    @Override
    public User getById(Long id) {
        for (User user : Database.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NoSuchElementException("User with ID: " + id + " not found");
    }

    @Override
    public void updateById(Long id, User user) {
        User userById = getById(id);
        userById.setUsername(user.getUsername());
        userById.setEmail(user.getEmail());
        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userById.setAge(user.getAge());
    }

    @Override
    public void deleteById(Long id) {
        User user = getById(id);
        Database.users.remove(user);

    }
}
