package repository;

import model.Center;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CenterRepository {
    private Map<String, Center> centers;

    public CenterRepository() {
        this.centers = new ConcurrentHashMap<>();
    }

    public Map<String, Center> getCenters() {
        return centers;
    }

    public void setCenters(Map<String, Center> centers) {
        this.centers = centers;
    }
}
