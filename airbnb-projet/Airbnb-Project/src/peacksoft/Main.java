package peacksoft;

import peacksoft.dao.impl.AnnouncementDaoImpl;
import peacksoft.dao.impl.FavoriteDaoImpl;
import peacksoft.dao.impl.UserDaoImpl;
import peacksoft.database.Database;
import peacksoft.enums.HouseType;
import peacksoft.models.Announcement;
import peacksoft.models.User;
import peacksoft.services.AnnouncementService;
import peacksoft.services.FavoriteService;
import peacksoft.services.UserService;
import peacksoft.services.impl.AnnouncementServiceImpl;
import peacksoft.services.impl.FavoriteServiceImpl;
import peacksoft.services.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        UserDaoImpl userDao = new UserDaoImpl(database);
        UserService userService = new UserServiceImpl(userDao);

        AnnouncementDaoImpl announcementDao = new AnnouncementDaoImpl(database);
        AnnouncementService announcementService = new AnnouncementServiceImpl(announcementDao, userDao);

        FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl(database);
        FavoriteService favoriteService = new FavoriteServiceImpl(favoriteDao, userDao, announcementDao);

        User currentUser = null;

        while (true) {
            System.out.println();
            System.out.println("""
                    Press 0 - show all users
                    Press 1 - save user
                    Press 2 - find user by id
                    Press 3 - sign in
                    """);

            switch (new Scanner(System.in).nextInt()) {
                case 0 -> {
                    List<User> userList = userService.findAll();
                    for (User user : userList) {
                        System.out.println(user);
                    }

                    System.out.println(listIsEmpty(userList, User.class));
                }

                case 1 -> {
                    for (User user : createUsers()) {
                        userService.save(user);
                    }
                }

                case 2 -> {
                    System.out.print("Please provide user id: ");
                    System.out.println(userService.findById(new Scanner(System.in).nextLong()));
                }

                case 3 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();

                    try {
                        currentUser = userService.signIn(email, password);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }

                    while (currentUser != null) {
                        System.out.println();
                        System.out.println("""
                                Press 4 - save announcement
                                Press 5 - get announcements by user
                                Press 6 - get all announcements
                                Press 7 - add announcement to favorites
                                Press 8 - get favorite announcements by user
                                Press 9 - log out
                                """);

                        switch (new Scanner(System.in).nextInt()) {
                            case 4 -> {
                                String save = announcementService.save(currentUser.getId(),
                                        new Announcement(
                                                "Ihlas",
                                                "Bishkek",
                                                BigDecimal.valueOf(200),
                                                new ArrayList<>(List.of("https://example.com")),
                                                HouseType.APARTMENT
                                        )
                                );
                                System.out.println(save);
                            }

                            case 5 -> {
                                List<Announcement> userAnnouncements = announcementService.getAnnouncementsByUserId(currentUser.getId());
                                for (Announcement userAnnouncement : userAnnouncements) {
                                    System.out.println(userAnnouncement);
                                }

                                System.out.println(listIsEmpty(userAnnouncements, Announcement.class));
                            }

                            case 6 -> {
                                List<Announcement> allAnnouncements = announcementService.getAllAnnouncements();
                                for (Announcement announcement : allAnnouncements) {
                                    System.out.println(announcement);
                                }

                                System.out.println(listIsEmpty(allAnnouncements, Announcement.class));

                            }

                            case 7 -> {
                                System.out.println("Enter announcement id");
                                favoriteService.favoriteAnnouncement(currentUser.getId(), scanner.nextLong());
                            }

                            case 8 -> {
                                Map<User, List<Announcement>> allFavoriteAnnouncements = favoriteService.getAllFavoriteAnnouncements(currentUser.getId());
                                Set<Map.Entry<User, List<Announcement>>> entries = allFavoriteAnnouncements.entrySet();

                                for (Map.Entry<User, List<Announcement>> entry : entries) {
                                    System.out.println(entry.getKey());
                                    System.out.println("Announcements: [");
                                    for (Announcement announcement : entry.getValue()) {
                                        System.out.println(announcement);
                                    }
                                    System.out.println("]");
                                }
                            }

                            case 9 -> {
                                currentUser = null;
                                break;
                            }
                        }

                        if (currentUser == null) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static <T> String listIsEmpty(List<?> list, Class<T> object) {
        return list.isEmpty() ? String.format("%s list is empty", object.getSimpleName()) : null;
    }

    public static List<User> createUsers() {
        return new ArrayList<>(
                Arrays.asList(
                        new User(
                                "Elchibek Zhanybai",
                                "elchibek@gmail.com",
                                "elchibek123",
                                "avatar",
                                "12345"
                        ),
                        new User(
                                "David Smith",
                                "david@gmail.com",
                                "david123",
                                "avatar",
                                "123456"
                        ),
                        new User(
                                "John Doe",
                                "john@gmail.com",
                                "john123",
                                "avatar",
                                "1234567"
                        )
                )
        );
    }
}
