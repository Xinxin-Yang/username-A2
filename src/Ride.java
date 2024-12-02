import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public int maxRider; // 每个周期最多乘坐的游客数
    private int numOfCycles; // 已运行的周期数
        
    
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
        
        // 设置游乐设施的操作员
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
            if (rideOperator == null) {
                System.out.println("无法运行游乐设施：没有操作员！");
                return;
            }
            if (queue.isEmpty()) {
                System.out.println("No visitor in the queue.");
            } 
            while(!queue.isEmpty()) {
                int ridersCount = Math.min(queue.size(), maxRider); // 确定本次周期承载的游客数量
                System.out.println("本次周期将接载 " + ridersCount + " 名游客。");
                    for (int i = 0; i < ridersCount; i++) {
                        Visitor visitor = queue.poll(); 
                        rideHistory.add(visitor); 
                    }   
    
            numOfCycles++; // 增加周期计数
            System.out.println("游乐设施运行了 " + numOfCycles + " 个周期。");
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

        public void exportRideHistory(String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Visitor visitor : rideHistory) {
            writer.write(String.format("%s,%d,%s,%s,%s,%s,%s,%s,%s,%s",
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
            writer.newLine(); // 每位访客信息写入一行
        }
        System.out.println("Ride history successfully exported to file: " + fileName);
    } catch (IOException er) {
        System.err.println("Error exporting ride history: " + er.getMessage());
    }
        }

        public int numberOfVisitorsInQueue(){  //打印队列中游客的数量
            return queue.size();
        }
    

        public void importRideHistory(String fileName) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 10) { // 确保数据的格式正确
                Visitor visitor = new Visitor(
                        data[0], // Name
                        Integer.parseInt(data[1]), // Age
                        data[2], // Gender
                        data[3], // ID
                        data[4], // ContactInfo
                        data[5], // TicketNumber
                        data[6], // VisitDate
                        data[7], // TicketStatus
                        data[8], // HealthStatus
                        data[9]  // EmergencyContact
                );
                queue.add(visitor); // 将访客添加到等待队列中
            } else {
                System.err.println("Invalid data format: " + line);
            }
        }
        System.out.println("Ride history successfully imported from file: " + fileName);
    } catch (IOException er) {
        System.err.println("Error importing ride history: " + er.getMessage());
    }
}
}