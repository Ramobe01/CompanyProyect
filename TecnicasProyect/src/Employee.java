public abstract class Employee {
    private String id;
    private String name;
    private int salary;
    private EmployeeType role;

    public Employee(String id, String name){
        this.setId(id);
        this.setName(name);
    }

    public abstract String getBenefits();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public EmployeeType getRole() {
        return role;
    }

    public void setRole(EmployeeType role) {
        this.role = role;
    }
}
