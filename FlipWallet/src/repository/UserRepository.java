package repository;

import model.User;

import java.util.HashMap;

public class UserRepository {
    HashMap<String, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }
}
