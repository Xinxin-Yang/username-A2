import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private String rideStatus;  // The status of the ride
    private Employee rideOperator;  // Ride operator
    private final Queue<Visitor> queue;
    private final LinkedList<Visitor> rideHistory;

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
    public Ride(String rideName, String rideType, String rideStatus, Employee rideOperator, LinkedList<Visitor> queue, LinkedList<Visitor> rideHistory) {
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
        queue.add(visitor);  // 添加访客到队列
        System.out.println(visitor.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!queue.isEmpty()) {
            Visitor removedVisitor = queue.poll();
            System.out.println("Visitor " + removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("No visitors in the queue to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors in the queue for :");
            for (Visitor visitor : queue) {
                System.out.println(visitor);
            }
        }
    }


    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            // 让访客进行游乐，并加入历史
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor);
            System.out.println(visitor.getName() + " is riding the rollercoaster!");    
        } else {
            System.out.println("No visitor in the queue.");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to the ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println(visitor.getName() + (found ? " is" : " is not") + " in the ride history.");
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history.");
        } else {
            System.out.println("Ride History:");
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }

    public void rideHistorySort() {
    if (rideHistory.isEmpty()) {
        System.out.println("Ride history is empty. Nothing to sort.");
    } else {
        Collections.sort(rideHistory, new ComparatorVisitor());
        System.out.println("Ride history sorted.");
    }
}
}