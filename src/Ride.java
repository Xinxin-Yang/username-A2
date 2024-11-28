import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private String rideStatus;  // The status of the ride
    private Employee rideOperator;  // Ride operator
    private final Queue<Visitor> queue;
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
                //System.out.println("Name="+ visitor.getName() + " " + "Age="+ visitor.getAge() + " " + "Gender="+ visitor.getGender() + " " + "Id="+ visitor.getId() + " " + "ContactInfo="+ visitor.getContactInfo() + " " + "TicketNumber="+ visitor.getTicketNumber() + " " + "VisitDate="+ visitor.getVisitDate() + " " + "TicketStatus="+ visitor.getTicketStatus() + " " + "HealthStatus="+ visitor.getHealthStatus() + " " + "EmergencyContact="+ visitor.getEmergencyContact());
                System.out.println(String.format("Name=%s Age=%d Gender=%s Id=%s ContactInfo=%s TicketNumber=%s VisitDate=%s TicketStatus=%s HealthStatus=%s EmergencyContact=%s", 
                visitor.getName(), 
                visitor.getAge(), 
                visitor.getGender(), 
                visitor.getId(), 
                visitor.getContactInfo(), 
                visitor.getTicketNumber(), 
                visitor.getVisitDate(), 
                visitor.getTicketStatus(), 
                visitor.getHealthStatus(), 
                visitor.getEmergencyContact()));
            }
        }
    }


    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            // 让访客进行游乐，并加入历史
            for (Visitor v : queue) {
                addVisitorToHistory(v);
                System.out.println(v.getName() + " is riding the rollercoaster!");
            }    
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
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history.");
        } else {
            System.out.println("Ride History:");
            for (Visitor v : rideHistory) {
                System.out.println(String.format("Name=%s Age=%d Gender=%s Id=%s ContactInfo=%s TicketNumber=%s VisitDate=%s TicketStatus=%s HealthStatus=%s EmergencyContact=%s", 
                v.getName(), 
                v.getAge(), 
                v.getGender(), 
                v.getId(), 
                v.getContactInfo(), 
                v.getTicketNumber(), 
                v.getVisitDate(), 
                v.getTicketStatus(), 
                v.getHealthStatus(), 
                v.getEmergencyContact()));
            }
        }
    }
}