import java.time.LocalDateTime;
import java.time.Month;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        DriverRepository driverRepository = new DriverRepository();
        driverRepository.addDriver(1, 35.10F);
        driverRepository.addDriver(2, 15.15F);
        driverRepository.addDriver(3, 8.55F);
        driverRepository.addDriver(4, 11.28F);

        driverRepository.recordDelivery(1, LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0), LocalDateTime.of(1970, Month.JANUARY, 1, 1, 0, 0));
        driverRepository.recordDelivery(2, LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0), LocalDateTime.of(1970, Month.JANUARY, 1, 1, 30, 0));
        driverRepository.recordDelivery(2, LocalDateTime.of(1970, Month.JANUARY, 1, 1, 30, 0), LocalDateTime.of(1970, Month.JANUARY, 1, 2, 0, 0));

        System.out.println(driverRepository.getTotalCost());
    }
}
