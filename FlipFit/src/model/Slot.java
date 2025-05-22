package model;

import java.util.*;

public class Slot {
    private String id;
    private String workoutType;
    private String startTime;
    private int totalSeats;
    private int bookedSeats;
    private Set<String> bookedUsers;
    final Map<String, Integer> slotIds = new HashMap<>();

    public Slot(String id, String workoutType, String startTime, int totalSeats) {
        this.id = id;
        this.workoutType = workoutType;
        this.startTime = startTime;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
        this.bookedUsers = Collections.synchronizedSet(new HashSet<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Set<String> getBookedUsers() {
        return bookedUsers;
    }
}
