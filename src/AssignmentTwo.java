public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo part = new AssignmentTwo();
        part.partThree();
        part.partFourA();
        part.partFourB();

    }
    public void partThree(){
        // 创建一个 RollerCoaster 游乐设施
        Ride ride1 = new Ride();

        // 创建访客
        Visitor visitor1 = new Visitor("Tom", 23, "male", "111111","163-2678-1536", "adu001", "8am", "valid", "healthy", "425-2452-1463");
        Visitor visitor2 = new Visitor("Sherly", 29, "female", "222222","345-2452-7537", "adu002", "10am", "valid", "healthy", "743-6737-3578");
        Visitor visitor3 = new Visitor("Ben", 30, "male", "333333","155-3673-2573", "adu003", "2pm", "valid", "healthy", "843-7653-7895");
        Visitor visitor4 = new Visitor("David", 50, "male", "444444","573-2521-6743", "old001", "3pm", "valid", "hypertension", "369-3357-7757");
        Visitor visitor5 = new Visitor("Jack", 16, "male", "555555","532-5326-8853", "teen001", "9am", "valid", "healthy", "367-8946-3467");
 
        // 将访客添加到队列中
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);
 
        // 打印当前队列
        ride1.printQueue();
          
        // 从队列中移除一位访客
        ride1.removeVisitorFromQueue();
          
        // 打印队列
        ride1.printQueue();
             
        

    }
    public void partFourA(){
        Ride ride2 = new Ride();
        
        Visitor visitor1 = new Visitor("Lee", 24, "female", "666666","192-2674-1286", "adu004", "9am", "valid", "healthy", "575-7742-3733");
        Visitor visitor2 = new Visitor("Sharon", 24, "female", "777777","245-4852-5837", "adu005", "9am", "valid", "healthy", "553-9472-7930");
        Visitor visitor3 = new Visitor("Benny", 30, "female", "888888","125-3823-2383", "adu006", "4pm", "valid", "healthy", "993-7363-7826");
        Visitor visitor4 = new Visitor("David", 55, "male", "999999","689-2661-6113", "old002", "2pm", "valid", "healthy", "339-6357-7727");
        Visitor visitor5 = new Visitor("Jason", 17, "male", "000000","242-5756-8443", "teen002", "8am", "valid", "healthy", "777-8116-3647");
 
        ride2.addVisitorToHistory(visitor1);
        ride2.addVisitorToHistory(visitor2);
        ride2.addVisitorToHistory(visitor3);
        ride2.addVisitorToHistory(visitor4);
        ride2.addVisitorToHistory(visitor5);
        
        ride2.printRideHistory();
        ride2.checkVisitorFromHistory(visitor2);
        System.out.println("Total visitors in history: " + ride2.numberOfVisitors());
        
        
    }
    public void partFourB(){
        Ride ride3 = new Ride();
        
        Visitor visitor1 = new Visitor("Lee", 24, "female", "666666","192-2674-1286", "adu004", "9am", "valid", "healthy", "575-7742-3733");
        Visitor visitor2 = new Visitor("Sharon", 24, "female", "777777","245-4852-5837", "adu005", "9am", "valid", "healthy", "553-9472-7930");
        Visitor visitor3 = new Visitor("Benny", 30, "female", "888888","125-3823-2383", "adu006", "4pm", "valid", "healthy", "993-7363-7826");
        Visitor visitor4 = new Visitor("David", 55, "male", "999999","689-2661-6113", "old002", "2pm", "valid", "healthy", "339-6357-7727");
        Visitor visitor5 = new Visitor("Jason", 17, "male", "000000","242-5756-8443", "teen002", "8am", "valid", "healthy", "777-8116-3647");
 
        ride3.addVisitorToHistory(visitor1);
        ride3.addVisitorToHistory(visitor2);
        ride3.addVisitorToHistory(visitor3);
        ride3.addVisitorToHistory(visitor4);
        ride3.addVisitorToHistory(visitor5);
        
        ride3.rideHistorySort();
        ride3.printRideHistory();
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}