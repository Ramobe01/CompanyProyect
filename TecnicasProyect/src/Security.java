public class Security extends Employee{

    private  int salary;
    public Security(String id, String name) {
        super(id, name);
        setSalary(1500000);
        setRole(EmployeeType.SECURITY);
    }

    @Override
    public String getBenefits() {
        String employeeBenefits = "\n|HealthCare: " + this.getSalary()*0.04 + "$\n|Pension: " + this.getSalary()*0.04 + "$\n|Layoffs: "+ this.getSalary()
                + "$\n|interest on layoffs: " + this.getSalary()*0.12 + "$\n|Grants: " + this.getSalary();
        return employeeBenefits;
    }
}
