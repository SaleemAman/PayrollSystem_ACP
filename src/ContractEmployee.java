public class ContractEmployee extends Employee implements Payable {
    private int contractDuration;

    public ContractEmployee(String empId, String name, double basicSalary, int contractDuration) {
        super(empId, name, basicSalary);
        this.contractDuration = contractDuration;
    }

    @Override
    public double calculateTax() {
        return getBasicSalary() * 0.05;
    }

    @Override
    public double calculateNetSalary() {
        return getBasicSalary() - calculateTax();
    }

    @Override
    public void generatePayslip() {
        System.out.println("\n--- PAYSLIP: CONTRACT EMPLOYEE ---");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Duration: " + this.contractDuration + " months");
        System.out.printf("Net Salary: %.2f\n", calculateNetSalary());
        System.out.println("----------------------------------");
    }
}