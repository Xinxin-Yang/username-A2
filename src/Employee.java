public class Employee extends Person {
    private String role;  //职责
    private String department; //部门
    private String workStatus;
    private int workHours;

    // Default constructor
    public Employee() {
        super(); // Calling the Person class constructor
        this.role = "Unknown";
        this.department = "Unknown";
        this.workStatus = "Unknown";
        this.workHours = 8;
    }

    // Parameterized constructor
    public Employee(String name, int age, String gender, String id, String contactInfom, String role, String department, String workStatus, int workHours) {
        super(name, age, gender, id, contactInfom); // Calling the Person class constructor
        this.role = role;
        this.department = department;
        this.workStatus = workStatus;
        this.workHours = workHours;
    }

    // Getters and setters
    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setWorkStatus(String workStatus){
        this.workStatus = workStatus;
    }

    public String getWorkStatus(){
        return workStatus;
    }

    public void setWorkHours(int workHours){
        this.workHours = workHours;
    }

    public int getWorkHours(){
        return workHours;
    }
}