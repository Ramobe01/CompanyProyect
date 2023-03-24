public class Ceo extends Employee{
    public Ceo(String id, String name) {
        super(id, name);
        setSalary(15700000);
        setRole(EmployeeType.CEO);
    }

    @Override
    public String getBenefits() {
        String employeeBenefits = "\n|HealthCare: " + this.getSalary()*0.04 + "$\n|Pension: " + this.getSalary()*0.04 +  "$\n|Solidarity: " + this.getSalary()*0.01;
        return employeeBenefits;
    }
}
