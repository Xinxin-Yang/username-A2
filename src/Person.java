public abstract class Person {
    public String name;
    public int age;
    public String gender;
    public String id;
    public String contactInfo;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.id = "Unknown";
        this.contactInfo = "Unknown";
    }

    // Parameterized constructor
    public Person(String name, int age, String gender, String id, String contactInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }

    public String getContactInfo(){
        return contactInfo;
    }
}