import java.sql.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Arrays;

public class Company {

    private static Hashtable<EmployeeType, ArrayList<Employee>> employeeList = new Hashtable<>();
    private static int employeeCounter;

    private static boolean employeeExist(Employee employee){
        for (EmployeeType employeeType: employeeList.keySet()) {
            for (Employee employeeI:employeeList.get(employeeType)) {
                if (employeeI.getId().equals(employee.getId())) {
                    System.out.println("The employee with ID " + employee.getId() + " is already in the system.");
                    return true;
                }
            }
        }
        return false;
    }

    private static void setEmployeeCounter(){
        employeeCounter += 1;
    }

    public static void addEmployee(EmployeeType role, Employee employee) {

        if (employee.getId().isEmpty() || employee.getName().isEmpty() || !isNumeric(employee.getId()) || !containsletters(employee.getName()) ) {
            System.out.println("Invalid input. Please check that the id is a valid number and the name does not contains any special characters.");
        }
        else{
            if (!employeeExist(employee)) {
                if(employeeList.get(role) == null){
                    employeeList.put(role,new ArrayList<Employee>());
                }
                setEmployeeCounter();
                employeeList.get(role).add(employee);
                if(employeeCounter > 10)
                    System.out.println("The employee with id " + employee.getId() + " was added successfully");
            }
        }
    }

    public static String getEmployeeInfo(String id){
        String employeeInfo;
        for (EmployeeType employeeType: employeeList.keySet()) {
            for (Employee employeeI : employeeList.get(employeeType)) {
                if (employeeI.getId().equals(id)) {
                    employeeInfo = "|Role: " + employeeType.getValue() + "\n|Id: " + id  + "\n|Name: " + employeeI.getName() + "\n|Salary: " +
                            employeeI.getSalary() + "$" + "\n|Benefits: " + employeeI.getBenefits() + "$";
                    return employeeInfo;
                }
            }
        }
        return "The employee with id " + id + " doesn't exist";
    }

    public static void showEmployeesRole(EmployeeType employeeType){
        System.out.println(employeeType.getValue());
        for (int i = 0; i < employeeList.get(employeeType).size(); i++) {
            System.out.println((i+1) + ". " + employeeList.get(employeeType).get(i).getId());
        }
    }

    public static String getEmployeeByIndex(EmployeeType employeeType, int index){
        String employeeInfo;
        try{
            Employee employee = employeeList.get(employeeType).get(index-1);
            if(employeeList.get(employeeType).get(index-1) == null){
                return "Incorrect option";
            }
            employeeInfo = "|Role: " + employeeType.getValue() + "\n|Id: " + employee.getId() + "\n|Name: " + employee.getName() + "\n|Salary: " +
                    employee.getSalary() + "$" + "\n|Benefits: " + employee.getBenefits() + "$";
            return employeeInfo;
        }catch (IndexOutOfBoundsException e){
            employeeInfo = "Incorrect Option";
        }
        return employeeInfo;
    }

    public static Employee employeeExist(String id){
        for (EmployeeType employeeType: employeeList.keySet()) {
            for (Employee employeeI:employeeList.get(employeeType)) {
                if (employeeI.getId().equals(id)) {
                    return employeeI;
                }
            }
        }
        return null;
    }

    public static boolean hasSameRole(EmployeeType employeeRole,EmployeeType newRole){
        if (employeeRole == newRole){
            return true;
        }
        else{
            return false;
        }
    }

    public static void deleteEmployee(Employee employee, EmployeeType oldRole){
        int employeeIndex = employeeList.get(oldRole).indexOf(employee);
        employeeList.get(oldRole).remove(employeeIndex);
    }

    public static Employee createEmployee(String employeeType,String id, String name){
        Employee employee;
        switch (employeeType){
            case "General Services Employee":
                employee = new GeneralServices(id,name);
                break;
            case "Human Talent Coordinator":
                employee = new HumanTalent(id,name);
                break;
            case "Security Employee":
                employee = new Security(id,name);
                break;
            case "Production Employee":
                employee = new Producer(id,name);
                break;
            case "CEO":
                employee = new Ceo(id,name);
                break;
            default:
                employee = null;
                break;
        }
        return employee;
    }

    public static void changeRole(String id,EmployeeType newRole){
        Employee employee = employeeExist(id);

        if(employee == null){
            System.out.println("The employee with ID " + id + " isn't in the system.");
        }
        else {
            if (!hasSameRole(employee.getRole(), newRole)){
                String employeeId = employee.getId();
                String employeeName = employee.getName();
                deleteEmployee(employee,employee.getRole());
                addEmployee(newRole,createEmployee(newRole.getValue(),employeeId,employeeName));
                System.out.println("The employee's role was changed");
            }
            else {
                System.out.println("The employee's role is already it");
            }
        }
    }

    public static boolean isNumeric(String id) {
        boolean result;

        try{
            var idNumber = Integer.parseInt(id);
            if(idNumber > 0){
                result = true;
            }else{
                return false;
            }
        }
        catch (NumberFormatException exception){
            result = false;
        }
        return result;
    }

    public static boolean containsletters(String id) {

        if(id.matches("[a-zA-Z]+")){
            return true;
        }
        else return false;
        }

    }
