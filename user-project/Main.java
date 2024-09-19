package java22;

import java22.models.User;
import java22.service.UserService;
import java22.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService<User, Long> userService = new UserServiceImpl();
        String message1 = userService.save(new User(1L, "elchibek", "elchibek@gmail.com", "elchibek", "zhanybai", 36));
        System.out.println(message1);

        userService.save(new User(2L, "username", "email", "firstName", "lastName", 21));


        System.out.println(userService.getAll());

        try {
            System.out.println(userService.getById(3L));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        userService.updateById(2L, new User(2L, "newusername", "newemail", "newfirstname", "newlastname", 23));

        try {
            System.out.println(userService.deleteById(1L));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        for (User user : userService.getAll()) {
            System.out.println(user);
        }
    }
}
