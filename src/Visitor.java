public class Visitor extends Person {
    private final String ticketNumber;  //Ticket serial number
    private final String visitDate;  //Play time
    private final String ticketStatus;  //Ticket status, such as "valid", "expired", "refunded", etc.
    private final String healthStatus;  //Health status
    private final String emergencyContact;  //Emergency contact number


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

    public String toCSV() {
        return String.format("%s,%d,%s,%s,%s,%s,%s,%s,%s,%s", getName(), getAge(), getGender(), getId(), getContactInfo(), ticketNumber, visitDate, ticketStatus, healthStatus, emergencyContact);
    }

    public static Visitor fromCSV(String csv) {
        String[] data = csv.split(",");
        return new Visitor(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
    }
    
    @Override
    public String toString() {
        return "Visitor[name=" + getName() + ", age=" + getAge() + ",Gender=" + getGender() + ",Id=" + getId()+ ",ContactInfo=" + getContactInfo() + ",TicketNumber=" + ticketNumber + ",VisitDate=" + visitDate + ",TicketStatus=" + ticketStatus + ",HealthStatus=" + healthStatus + ",EmergencyContact=" + emergencyContact +"]";
    }
}