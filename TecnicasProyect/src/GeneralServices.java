import javax.sql.rowset.serial.SerialArray;

public class GeneralServices extends Employee{

    public GeneralServices(String id, String name){
        super(id, name);
        setSalary(1160000);
        setRole(EmployeeType.GENERALSERVICES);
    }

    @Override
    public String getBenefits() {
        String employeeBenefits = "\n|HealthCare: " + this.getSalary()*0.04 + "$\n|Pension: " + this.getSalary()*0.04 + "$\n|Layoffs: "+ this.getSalary()
                + "$\n|interest on layoffs: " + this.getSalary()*0.12 + "$\n|Grants: " + this.getSalary();
        return employeeBenefits;
    }
}
