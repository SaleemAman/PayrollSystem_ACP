import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollSystem {

    private static final Employee[] employees = new Employee[5];
    private static int employeeCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Management System");
        boolean running = true;

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewAllEmployees();
                        break;
                    case 3:
                        searchEmployee();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the bad input
            }
        }
        System.out.println("Exiting program. Goodbye!");
    }

    public static void addEmployee() {
        if (employeeCount >= 5) {
            System.out.println("Cannot add more employees. Maximum limit reached.");
            return;
        }

        System.out.print("Enter Type (Permanent/Contract): ");
        String type = scanner.nextLine();

        if (!type.equalsIgnoreCase("Permanent") && !type.equalsIgnoreCase("Contract")) {
            System.out.println("Invalid employee type. Please try again.");
            return;
        }

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (type.equalsIgnoreCase("Permanent")) {
            System.out.print("Enter Bonus: ");
            double bonus = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            employees[employeeCount] = new PermanentEmployee(id, name, salary, bonus);
        } else { // Contract
            System.out.print("Enter Duration (months): ");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            // FIX: The order of 'salary' and 'duration' is now correct.
            employees[employeeCount] = new ContractEmployee(id, name, salary, duration);
        }

        employeeCount++;
        System.out.println("Employee added successfully!");
    }

    public static void viewAllEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\n--- ALL EMPLOYEES ---");
        System.out.println("ID\t\tName\t\tNet Salary");
        System.out.println("------------------------------------------");
        for (int i = 0; i < employeeCount; i++) {
            Employee emp = employees[i];
            double netSalary = ((Payable) emp).calculateNetSalary();
            System.out.println(emp.getEmpId() + "\t\t" + emp.getName() + "\t" + String.format("%.2f", netSalary));
        }
    }

    public static void searchEmployee() {
        if (employeeCount == 0) {
            System.out.println("No employees to search.");
            return;
        }

        System.out.print("Enter Employee ID to search for: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmpId().equalsIgnoreCase(id)) {
                Employee emp = employees[i];
                double netSalary = ((Payable) emp).calculateNetSalary();
                System.out.println("\n--- Employee Found ---");
                System.out.println("ID: " + emp.getEmpId());
                System.out.println("Name: " + emp.getName());
                System.out.println("Basic Salary: " + emp.getBasicSalary());
                System.out.printf("Net Salary: %.2f\n", netSalary);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID '" + id + "' not found.");
        }
    }
}