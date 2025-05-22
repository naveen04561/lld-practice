import java.time.LocalDateTime;

public class Delivery {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int driverId;

    public Delivery(LocalDateTime startTime, LocalDateTime endTime, int driverId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.driverId = driverId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
