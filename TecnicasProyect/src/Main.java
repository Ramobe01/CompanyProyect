import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Empleados por defecto
        //GeneralServices
        Company.addEmployee(EmployeeType.GENERALSERVICES, new GeneralServices("1001", "Fabian"));
        Company.addEmployee(EmployeeType.GENERALSERVICES, new GeneralServices("1002", "Samuel"));
        //HumanTalent
        Company.addEmployee(EmployeeType.HUMANTALENT, new HumanTalent("2001", "Sara"));
        //Security
        Company.addEmployee(EmployeeType.SECURITY, new Security("3001", "Manuela"));
        Company.addEmployee(EmployeeType.SECURITY, new Security("3002", "Daniela"));
        //Producer
        Company.addEmployee(EmployeeType.PRODUCTION, new Producer("4001", "Santiago"));
        Company.addEmployee(EmployeeType.PRODUCTION, new Producer("4002", "Angie"));
        Company.addEmployee(EmployeeType.PRODUCTION, new Producer("4003", "Juan"));
        Company.addEmployee(EmployeeType.PRODUCTION, new Producer("4004", "Miguel"));
        //Ceo
        Company.addEmployee(EmployeeType.CEO, new Ceo("5001", "Juliana"));
        boolean flag = true;
        while (flag) {
            var entry = new Scanner(System.in);
            System.out.println("");
            System.out.println("1. Register an Employee ");
            System.out.println("2. Change Employee Duty ");
            System.out.println("3. Search by Id ");
            System.out.println("4. Search by Role ");
            System.out.println("5. Exit");
            System.out.print("Enter your option: ");
            try {
                int option = entry.nextInt();
                switch (option) {
                    case 1:
                        Scanner scanner = new Scanner(System.in);

                        System.out.print("\nPlease enter the Id of the employee: ");
                        String id = scanner.nextLine();


                        System.out.print("\nPlease enter the name of the employee: ");
                        String name = scanner.nextLine();

                        System.out.println("\nPlease choose the role of the employee:");
                        System.out.println("1. General Service ");
                        System.out.println("2. Human Talent ");
                        System.out.println("3. Security ");
                        System.out.println("4. Production ");
                        System.out.println("5. Ceo ");
                        System.out.print("Enter your option: ");
                        int option2 = scanner.nextInt();


                        switch (option2) {

                            case 1:
                                Company.addEmployee(EmployeeType.GENERALSERVICES, new GeneralServices(id, name));
                                break;
                            case 2:
                                Company.addEmployee(EmployeeType.HUMANTALENT, new HumanTalent(id, name));
                                break;
                            case 3:
                                Company.addEmployee(EmployeeType.SECURITY, new Security(id, name));
                                break;
                            case 4:
                                Company.addEmployee(EmployeeType.PRODUCTION, new Producer(id, name));
                                break;
                            case 5:
                                Company.addEmployee(EmployeeType.CEO, new Ceo(id, name));
                                break;
                            default:
                                System.out.println("Incorrect Option, please choose a valid option from above");
                                break;
                        }
                        break;


                    case 2:
                        var scannerChange = new Scanner((System.in));
                        System.out.print("Please enter the Id of the employee to change: ");
                        String idToChange = scannerChange.nextLine();
                        System.out.println("Please choose the new role:");
                        System.out.println("1. General Service ");
                        System.out.println("2. Human Talent ");
                        System.out.println("3. Security ");
                        System.out.println("4. Production ");
                        System.out.println("5. Ceo ");
                        System.out.print("Enter your option: ");
                        int optionChange = scannerChange.nextInt();
                        switch (optionChange){

                            case 1:
                                Company.changeRole(idToChange,EmployeeType.GENERALSERVICES);
                                break;

                            case 2:
                                Company.changeRole(idToChange,EmployeeType.HUMANTALENT);
                                break;

                            case 3:
                                Company.changeRole(idToChange,EmployeeType.SECURITY);
                                break;
                            case 4:
                                Company.changeRole(idToChange,EmployeeType.PRODUCTION);
                                break;
                            case 5:
                                Company.changeRole(idToChange,EmployeeType.CEO);
                                break;
                            default:
                                System.out.println("Incorrect Option, please choose a valid option from above");
                                break;
                        }
                        break;
                    case 3:
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Please enter the Id of the employee: ");
                        String id2 = scanner1.nextLine();
                        System.out.println(Company.getEmployeeInfo(id2));
                        break;
                    case 4:
                        var entry2 = new Scanner(System.in);
                        System.out.println("Please choose the role for the search:");
                        System.out.println("1. General Service ");
                        System.out.println("2. Human Talent ");
                        System.out.println("3. Security ");
                        System.out.println("4. Production ");
                        System.out.println("5. Ceo ");
                        System.out.print("Enter your option: ");
                        int option3 = entry2.nextInt();
                        switch (option3){

                            case 1:
                                Company.showEmployeesRole(EmployeeType.GENERALSERVICES);
                                System.out.print("Insert the number of the employee: ");
                                int option4 = entry2.nextInt();
                                System.out.println(Company.getEmployeeByIndex(EmployeeType.GENERALSERVICES,option4));
                                break;

                            case 2:
                                Company.showEmployeesRole(EmployeeType.HUMANTALENT);
                                System.out.print("Insert the number of the employee: ");
                                int option5 = entry2.nextInt();
                                System.out.println(Company.getEmployeeByIndex(EmployeeType.HUMANTALENT,option5));
                                break;

                            case 3:
                                Company.showEmployeesRole(EmployeeType.SECURITY);
                                System.out.print("Insert the number of the employee: ");
                                int option6 = entry2.nextInt();
                                System.out.println(Company.getEmployeeByIndex(EmployeeType.SECURITY,option6));
                                break;
                            case 4:
                                Company.showEmployeesRole(EmployeeType.PRODUCTION);
                                System.out.print("Insert the number of the employee: ");
                                int option7 = entry2.nextInt();
                                System.out.println(Company.getEmployeeByIndex(EmployeeType.PRODUCTION,option7));
                                break;
                            case 5:
                                Company.showEmployeesRole(EmployeeType.CEO);
                                System.out.print("Insert the number of the employee: ");
                                int option8 = entry2.nextInt();
                                System.out.println(Company.getEmployeeByIndex(EmployeeType.CEO,option8));
                                break;
                            default:
                                System.out.println("Incorrect Option, please choose a valid option from above");
                                break;
                        }
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect Option");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Incorrect Option");
            }
        }

    }
}