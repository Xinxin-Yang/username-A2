import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface, FileManager<Visitor> {
    private String rideName;
    private String rideType;
    private String rideStatus;  // The status of the ride
    private Employee rideOperator;  // Ride operator
    private final Queue<Visitor> queue;
    private final LinkedList<Visitor> rideHistory;
    public int maxRider; // Maximum number of passengers per cycle
    private int numOfCycles; // Number of cycles that have been run
        
    
    // Default constructor
        public Ride() {
            this.rideName = "Unknown";
            this.rideType = "Unknown";
            this.rideStatus = "Unknown";
            this.rideOperator = null; // No operator assigned
            this.queue = new LinkedList<>();
            this.rideHistory = new LinkedList<>();
            this.maxRider = 1;
            this.numOfCycles = 0;
        }
    
        // Parameterized constructor
        public Ride(String rideName, String rideType, String rideStatus, Employee rideOperator, LinkedList<Visitor> queue, LinkedList<Visitor> rideHistory, int maxRider, int numOfCycles) {
            this.rideName = rideName;
            this.rideType = rideType;
            this.rideStatus = rideStatus;
            this.rideOperator = rideOperator;
            this.queue = new LinkedList<>();
            this.rideHistory = new LinkedList<>();
            this.maxRider = maxRider;
            this.numOfCycles = numOfCycles;
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
        
        // The operator who sets up the ride
        public void setRideOperator(Employee rideOperator) {
            this.rideOperator = rideOperator;
        }
        
        public Employee getRideOperator() {
            return rideOperator;
        }

    
        @Override
        public void addVisitorToQueue(Visitor visitor) {
            queue.add(visitor);  // Add a visitor to the queue
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
            if (rideOperator == null) {
                System.out.println("No operator assigned, cannot run this operation!");
                return;
            }
            if (queue.isEmpty()) {
                System.out.println("No visitor in the queue.");
            } 
            while(!queue.isEmpty()) {
                int ridersCount = Math.min(queue.size(), maxRider); // Determine the number of visitors carried in this cycle
                System.out.println("This cycle will be loaded " + ridersCount + " tourists.");
                    for (int i = 0; i < ridersCount; i++) {
                        Visitor visitor = queue.poll(); 
                        rideHistory.add(visitor); 
                    }   
    
            numOfCycles++; // Increase cycle count
            System.out.println("The ride is running " + numOfCycles + " cycles.");
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
                }  //Iterator traversal is used
            }
        }  //Iterator traversal is used
    
        public void rideHistorySort() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty. Nothing to sort.");
        } else {
            Collections.sort(rideHistory, new ComparatorVisitor());
            System.out.println("Ride history sorted.");
        }
        }

        public static void logError(String message) {
            System.err.println("ERROR: " + message);
        }

         
        @Override
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toCSV());
                writer.newLine();
            }
            System.out.println("Export successful: " + fileName);
        } catch (IOException e) {
            ErrorHandler.logError("Export failed: " + e.getMessage());
        }
    }

        @Override
    public Queue<Visitor> importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.add(Visitor.fromCSV(line));
            }
            System.out.println("Import successful: " + fileName);
        } catch (IOException e) {
            ErrorHandler.logError("Import failed: " + e.getMessage());
        } 
        return queue;
    }


        public int numberOfVisitorsInQueue(){  //Print the number of visitors in the queue
            return queue.size();
        }
    

}