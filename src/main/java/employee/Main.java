package employee;

public class Main {

    public static void main(String[] args) {
        double basic = 50000;
        SalaryCalculator calc = new SalaryCalculator();

        System.out.println("Basic Pay        : " + basic);
        System.out.println("HRA              : " + calc.calculateHRA(basic));
        System.out.println("DA               : " + calc.calculateDA(basic));
        System.out.println("Gross Salary     : " + calc.calculateGross(basic));
        System.out.println("Total Deductions : " + calc.calculateTotalDeductions(basic));
        System.out.println("Net Salary       : " + calc.calculateNet(basic));
    }
}