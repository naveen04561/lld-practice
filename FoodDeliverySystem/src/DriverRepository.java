import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository {
    private final Map<Integer, Driver> drivers;
    private final Map<Integer, List<Delivery>> deliveries;

    public DriverRepository() {
        drivers = new HashMap<>();
        deliveries = new HashMap<>();
    }

    public void addDriver(int driverId, float usdHourlyRate) {
        drivers.put(driverId,new Driver(driverId,usdHourlyRate));
    }

    public void recordDelivery(int driverId, LocalDateTime startTime, LocalDateTime endTime) {
        deliveries.computeIfAbsent(driverId, k -> new ArrayList<>()).add(new Delivery(startTime, endTime, driverId));
    }

    public float getTotalCost() {
        float totalCost = 0.0F;

        for (Map.Entry<Integer, List<Delivery>> entry : deliveries.entrySet()) {
            Integer driverId = entry.getKey();
            List<Delivery> deliveryList = entry.getValue();

            for (Delivery delivery : deliveryList) {
                long minutes = Duration.between(delivery.getStartTime(), delivery.getEndTime()).toMinutes();
                float hours = ((float)minutes/60F);
                totalCost += (drivers.get(driverId).getUsdHourlyRate()*(hours));
            }
        }

        return totalCost;
    }
}
