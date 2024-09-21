package peacksoft.services;

import peacksoft.models.User;

import java.util.List;

public interface UserService {
    String save(User user);

    User findById(long l);

    User signIn(String email, String password);

    List<User> findAll();
}
