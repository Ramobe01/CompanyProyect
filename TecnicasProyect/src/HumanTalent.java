public class HumanTalent extends Employee{

    public HumanTalent(String id, String name) {
        super(id, name);
        setSalary(3000000);
        setRole(EmployeeType.HUMANTALENT);
    }


    @Override
    public String getBenefits() {
        String employeeBenefits = "\n|HealthCare: " + this.getSalary()*0.04 + "$\n|Pension: " + this.getSalary()*0.04 + "$\n|Layoffs: "+ this.getSalary()
                + "$\n|interest on layoffs: " + this.getSalary()*0.12 + "$\n|Grants: " + this.getSalary() + "$\n|Solidarity: "+ this.getSalary()*0.01;
        return employeeBenefits;
    }
}
