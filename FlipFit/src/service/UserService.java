package service;

import model.Center;
import model.Slot;
import model.User;
import repository.CenterRepository;
import repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    UserRepository userRepository;
    CenterRepository centerRepository;

    public UserService(UserRepository userRepository, CenterRepository centerRepository) {
        this.userRepository = userRepository;
        this.centerRepository = centerRepository;
    }

    public void registerUser(String name, int age, String city) {
        userRepository.getUsers().put(name, new User(name, age, city));
    }

    public Map<String, Set<String>> viewUserBooking(String name, String date) {
        if (!userRepository.getUsers().containsKey(name)) throw new RuntimeException("User not found");
        return userRepository.getUserBookings().get(name);
    }

    public synchronized void bookSlot(String centerName, String userId, String slotId, String date) {
        if (!userRepository.getUsers().containsKey(userId)) throw new RuntimeException("User not found");
        Center center = centerRepository.getCenters().get(centerName);
        if (center == null) throw new RuntimeException("Center not found");
        Slot slot = center.getSlots().stream().filter(s -> Objects.equals(s.getId(), slotId)).findFirst().orElse(null);
        if (slot == null || slot.getBookedSeats() >= slot.getTotalSeats()) throw new RuntimeException("Slot unavailable");
        if (!slot.getBookedUsers().add(userId)) throw new RuntimeException("User already booked");
        slot.setBookedSeats(slot.getBookedSeats() + 1);
        userRepository.getUserBookings().computeIfAbsent(userId, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(date, k -> new HashSet<>()).add(slotId);
    }

    public void cancelSlot(String centerName, String userId, String slotId, String date) {
        if (!userRepository.getUsers().containsKey(userId)) throw new RuntimeException("User not found");
        Center center = centerRepository.getCenters().get(centerName);
        if (center == null) throw new RuntimeException("Center not found");
        Slot slot = center.getSlots().stream().filter(s -> Objects.equals(s.getId(), slotId)).findFirst().orElse(null);
        if (slot == null || !slot.getBookedUsers().remove(userId)) throw new RuntimeException("Booking not found");
        slot.setBookedSeats(slot.getBookedSeats() - 1);
        userRepository.getUserBookings().getOrDefault(userId, new HashMap<>()).getOrDefault(date, new HashSet<>()).remove(slotId);
    }
}
