public class Driver {
    private int driverId;
    private float usdHourlyRate;

    public Driver(int driverId, float usdHourlyRate) {
        this.driverId = driverId;
        this.usdHourlyRate = usdHourlyRate;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public float getUsdHourlyRate() {
        return usdHourlyRate;
    }

    public void setUsdHourlyRate(float usdHourlyRate) {
        this.usdHourlyRate = usdHourlyRate;
    }
}