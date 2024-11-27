import java.util.LinkedList;
import java.util.List;

public abstract class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private String rideStatus;  // The status of the ride
    private Employee rideOperator;  // Ride operator
    private final LinkedList<Visitor> queue;
    private final List<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown";
        this.rideType = "Unknown";
        this.rideStatus = "Unknown";
        this.rideOperator = null; // No operator assigned
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, String rideStatus, Employee rideOperator, List<Visitor> queue, List<Visitor> rideHistory) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideStatus = rideStatus;
        this.rideOperator = rideOperator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.offer(visitor);  // 添加访客到队列
        System.out.println(visitor.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current Queue: ");
        for (Visitor v : queue) {
            System.out.println(v.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor); // 让访客进行游乐，并加入历史
            System.out.println(visitor.getName() + " is riding the rollercoaster!");
        } else {
            System.out.println("No visitors in the queue.");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to the ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History: ");
        for (Visitor v : rideHistory) {
            System.out.println(v.getName());
        }
    }
}