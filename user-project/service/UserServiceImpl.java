package java22.service;

import java22.dao.UserDao;
import java22.dao.impl.UserDaoImpl;
import java22.exception.MyNotFoundException;
import java22.models.User;

import java.util.List;

public class UserServiceImpl implements UserService<User, Long> {
    private final UserDao<User, Long> userDao= new UserDaoImpl();

    @Override
    public String save(User user) {
        try {
            userDao.create(user);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "User successfully saved";
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        for (User user : getAll()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new MyNotFoundException("User with id: " + id + " not found");
    }

    @Override
    public User updateById(Long id, User user) {
        try {
            userDao.updateById(id, user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new IllegalArgumentException();
        }
        return user;
    }

    @Override
    public String deleteById(Long id) {
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "User successfully deleted";
    }
}
