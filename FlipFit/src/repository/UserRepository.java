package repository;

import model.User;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private Map<String, User> users;
    private Map<String, Map<String, Set<String>>> userBookings;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        this.userBookings = new ConcurrentHashMap<>();
    }

    public Map<String, Map<String, Set<String>>> getUserBookings() {
        return userBookings;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
