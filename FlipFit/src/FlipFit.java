
import model.Slot;
import repository.CenterRepository;
import repository.UserRepository;
import service.CenterService;
import service.UserService;

import java.util.*;

public class FlipFit {

    public static void main(String[] args) {
        try {
            UserRepository userRepository = new UserRepository();
            CenterRepository centerRepository = new CenterRepository();

            UserService userService = new UserService(userRepository, centerRepository);
            CenterService centerService = new CenterService(centerRepository);

            centerService.addCenter("bellandur", "bangalore", new HashSet<>(Arrays.asList("monday", "sunday")), 5);
            centerService.addWorkOutType("bellandur", "weights");
            centerService.addWorkOutType("bellandur", "cardio");
            centerService.addWorkOutType("bellandur", "yoga");

            centerService.addSlots("bellandur", "weights", "6:00", 2);
            centerService.addSlots("bellandur", "yoga", "8:00", 1);

            userService.registerUser("Vivek", 16, "bangalore");
            userService.registerUser("Pavan", 20, "bangalore");
            userService.registerUser("Varun", 22, "bangalore");

            List<Slot> slotsList = centerService.getAvailableSlot("bellandur", "28-05-2021");

            for (Slot slot : slotsList) {
                System.out.println(slot.getId() + slot.getWorkoutType() + slot.getStartTime() + slot.getTotalSeats());
            }

            userService.bookSlot("bellandur", "Vivek", "6:00", "28-05-2021");
            userService.bookSlot("bellandur", "Pavan", "6:00", "28-05-2021");

            System.out.println(userService.viewUserBooking("Vivek", "28-05-2021"));
            System.out.println(userService.viewUserBooking("Pavan", "29-05-2021").get("29-05-2021"));

            userService.cancelSlot("bellandur", "Vivek", "6:00", "28-05-2021");

            System.out.println(userService.viewUserBooking("Vivek", "28-05-2021"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
