package peacksoft.database;

import peacksoft.models.Announcement;
import peacksoft.models.Favorite;
import peacksoft.models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<User> users = new ArrayList<>();
    public List<Announcement> announcements = new ArrayList<>();
    public List<Favorite> favorites = new ArrayList<>();

}
