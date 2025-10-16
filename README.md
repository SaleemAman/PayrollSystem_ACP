Employee Payroll Management System 💼
A simple, console-based Employee Payroll Management System written in Java. This project was developed as an assignment for the CS51 Advanced Computer Programming course to demonstrate core Object-Oriented Programming (OOP) principles.

**Features ✨**
.**Add Employees**: Add new Permanent or Contract employees to the system.
.**View All Employees**: Display a list of all current employees along with their calculated net salary.
.**Search for an Employee**: Find a specific employee by their ID and view their detailed information.
.**Generate Payslips**: Print a formatted payslip for any employee.
.**Dynamic Calculations:** Automatically calculates taxes and net salaries based on employee type.

**OOP Concepts Applied �**�
This project is a practical application of the fundamental OOP concepts covered in the course lectures:

**1.Abstraction**: The Payable interface and the Employee abstract class  are used to hide complex implementation details and define a clear structure. The system focuses on what an employee object can do (like calculateNetSalary()) rather than how it does it.

**2.Inheritance**: The PermanentEmployee and ContractEmployee classes inherit common properties (like empId, name) and behaviors from the parent Employee class, promoting code reuse.

**3.Polymorphism**: The calculateTax() and generatePayslip()  methods have different implementations in the PermanentEmployee and ContractEmployee subclasses. When these methods are called on an Employee object, Java's dynamic method dispatch  ensures the correct version is executed at runtime.

**4.Encapsulation**: Data fields within the Employee class (like empId and basicSalary) are kept private. Access is controlled through public getter and setter methods, protecting the data from direct external modification.

**OUTPUT**
Welcome to Employee Payroll Management System

--- MAIN MENU ---
1. Add Employee
2. View All Employees
3. Search Employee
4. Exit
Choose an option: 1
Enter Type (Permanent/Contract): Permanent
Enter ID: E101
Enter Name: Ahmed Khan
Enter Basic Salary: 60000
Enter Bonus: 5000
Employee added successfully!
