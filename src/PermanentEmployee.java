public class PermanentEmployee extends Employee implements Payable {
    private double bonus;

    public PermanentEmployee(String empId, String name, double basicSalary, double bonus) {
        super(empId, name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTax() {
        return (getBasicSalary() + this.bonus) * 0.10;
    }

    @Override
    public double calculateNetSalary() {
        return (getBasicSalary() + this.bonus) - calculateTax();
    }

    @Override
    public void generatePayslip() {
        System.out.println("\n--- PAYSLIP: PERMANENT EMPLOYEE ---");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.printf("Net Salary: %.2f\n", calculateNetSalary());
        System.out.println("-----------------------------------");
    }
}