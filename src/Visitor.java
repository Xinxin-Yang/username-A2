public class Visitor extends Person {
    private String ticketNumber;  //票的序号
    private String visitDate;  //游玩时间
    private String ticketStatus;  //票务状态，如“有效”、“已过期”、“已退款”等。
    private String healthStatus;  //健康状况
    private String emergencyContact;  //紧急联系电话


    // Default constructor
    public Visitor() {
        super(); // Calling the Person class constructor
        this.ticketNumber = "Unknown";
        this.visitDate = "Unknown";
        this.ticketStatus = "Unknown";
        this.healthStatus = "healthy";
        this.emergencyContact = "Unknown";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String id, String contactInfom, String ticketNumber, String visitDate, String ticketStatus, String healthStatus, String emergencyContact) {
        super(name, age, gender, id, contactInfom); // Calling the Person class constructor
        this.ticketNumber = ticketNumber;
        this.visitDate = visitDate;
        this.ticketStatus = ticketStatus;
        this.healthStatus = healthStatus;
        this.emergencyContact = emergencyContact;
    }

    // Getters and setters
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setTicketStatus(String ticketStatus){
        this.ticketStatus = ticketStatus;
    }

    public String getTicketStatus(){
        return ticketStatus;
    }

    public void setHealthStatus(String healthStatus){
        this.healthStatus = healthStatus;
    }

    public String getHealthStatus(){
        return healthStatus;
    }

    public void setEmergencyContact(String emergencyContact){
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact(){
        return emergencyContact;
    }
}