public class Ride {
    private String rideName;
    private String rideType;
    private String rideStatus;  // The status of the ride
    private Employee rideOperator;  // Ride operator

    // Default constructor
    public Ride() {
        this.rideName = "Unknown";
        this.rideType = "Unknown";
        this.rideStatus = "Unknown";
        this.rideOperator = null; // No operator assigned
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, String rideStatus, Employee rideOperator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideStatus = rideStatus;
        this.rideOperator = rideOperator;
    }

    // Getters and setters
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideStatus(String rideStatus) {
        this.rideStatus = rideStatus;
    }

    public String getRideStatus() {
        return rideStatus;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }
    
    public Employee getRideOperator() {
        return rideOperator;
    }
}