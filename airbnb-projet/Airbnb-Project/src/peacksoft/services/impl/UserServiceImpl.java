package peacksoft.services.impl;

import peacksoft.dao.impl.UserDaoImpl;
import peacksoft.exceptions.InvalidEmailException;
import peacksoft.exceptions.NotFoundException;
import peacksoft.models.User;
import peacksoft.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public String save(User user) {
        try {
            if (!user.getEmail().contains("@")) throw new InvalidEmailException("Invalid email");
            if (user.getPassword().length() < 4) throw new IllegalArgumentException("Invalid password");
        } catch (IllegalArgumentException | InvalidEmailException e) {
            return "User not saved [ " + e.getMessage() + " ]";
        }
        userDao.save(user);
        return String.format("User with email: %s successfully saved", user.getEmail());
    }

    @Override
    public User findById(long id) {
        User foundUser;
        try {
            foundUser = userDao.findById(id);
        } catch (NotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return foundUser;
    }

    @Override
    public User signIn(String email, String password) {
        List<User> allUsers = userDao.findAll();
        for (User user : allUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Invalid email or password");
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
