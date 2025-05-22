package service;

import model.Center;
import model.Slot;
import repository.CenterRepository;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public class CenterService {
    private CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public void addCenter(String centerName, String cityName, Set<String> daysClosed, int numOfSlots) {
        if (centerRepository.getCenters().containsKey(centerName)) throw new RuntimeException("Center already exists");
        centerRepository.getCenters().put(centerName, new Center(centerName, cityName, daysClosed, numOfSlots));
    }

    public void addWorkOutType(String centerName, String name) {
        Center center = centerRepository.getCenters().get(centerName);
        if (center == null) throw new RuntimeException("Center not found");
        center.getWorkoutTypes().add(name);
    }

    public void addSlots(String centerName, String workoutType, String startTime, int numberOfSeats) {
        Center center = centerRepository.getCenters().get(centerName);
        if (center == null)
            throw new RuntimeException("Invalid center");
        center.getSlots().add(new Slot(startTime, workoutType, startTime, numberOfSeats));
    }

    public List<Slot> getAvailableSlot(String centerName, String date) {
        Center center = centerRepository.getCenters().get(centerName);
        if (center == null || center.getDaysClosed().contains(date))
            throw new RuntimeException("Center closed or not found");
        List<Slot> availableSlots = new ArrayList<>();
        for (Slot slot : center.getSlots()) {
            if (slot.getBookedSeats() < slot.getTotalSeats()) availableSlots.add(slot);
        }
        return availableSlots;
    }
}
