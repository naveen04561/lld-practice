package model;

import java.util.*;

public class Center {
    private String name;
    private String city;
    private Set<String> daysClosed;
    private Set<String> workoutTypes;
    private List<Slot> slots;
    private int numOfSlots;

    public Center(String name, String city, Set<String> daysClosed, int numOfSlots) {
        this.name = name;
        this.city = city;
        this.daysClosed = daysClosed;
        this.workoutTypes = new HashSet<>();
        this.slots = new ArrayList<>();
        this.numOfSlots = numOfSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<String> getDaysClosed() {
        return daysClosed;
    }

    public void setDaysClosed(Set<String> daysClosed) {
        this.daysClosed = daysClosed;
    }

    public Set<String> getWorkoutTypes() {
        return workoutTypes;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
