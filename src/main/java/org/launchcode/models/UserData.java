package org.launchcode.models;
import java.util.ArrayList;

import java.util.List;

public class UserData {
    private static final List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
