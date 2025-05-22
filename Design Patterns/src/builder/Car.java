package builder;

public class Car {
    private String engine;
    private String body;
    private int seats;

    // Private constructor to ensure the car is built through the builder
    private Car() {}

    // Getters
    public String getEngine() {
        return engine;
    }

    public String getBody() {
        return body;
    }

    public int getSeats() {
        return seats;
    }

    // Display car details
    public void showCar() {
        System.out.println("Car Specifications:");
        System.out.println("Engine: " + engine);
        System.out.println("Body: " + body);
        System.out.println("Seats: " + seats);
    }

    // Static inner class for the Builder
    public static class Builder {
        private String engine;
        private String body;
        private int seats;

        // Method to set the engine
        public Builder setEngine(String engine) {
            this.engine = engine;
            return this; // Return the builder for method chaining
        }

        // Method to set the body
        public Builder setBody(String body) {
            this.body = body;
            return this; // Return the builder for method chaining
        }

        // Method to set the seats
        public Builder setSeats(int seats) {
            this.seats = seats;
            return this; // Return the builder for method chaining
        }

        // Method to build the Car object
        public Car build() {
            Car car = new Car();
            car.engine = this.engine;
            car.body = this.body;
            car.seats = this.seats;
            return car; // Return the built car
        }
    }
}