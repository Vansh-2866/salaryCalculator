package employee;

public class SalaryCalculator {

    public double calculateHRA(double basic) {
        return basic * 0.20;
    }

    public double calculateDA(double basic) {
        return basic * 0.10;
    }

    public double calculateGross(double basic) {
        if (basic < 0) {
            throw new IllegalArgumentException("Basic pay cannot be negative");
        }
        return basic + calculateHRA(basic) + calculateDA(basic);
    }

    public double calculatePF(double basic) {
        return basic * 0.12;
    }

    public double calculateProfessionalTax() {
        return 200;
    }

    public double calculateIncomeTax(double gross) {
        if (gross > 50000) {
            return gross * 0.10;
        }
        return 0;
    }

    public double calculateTotalDeductions(double basic) {
        double gross = calculateGross(basic);
        return calculatePF(basic) + calculateProfessionalTax() + calculateIncomeTax(gross);
    }

    public double calculateNet(double basic) {
        return calculateGross(basic) - calculateTotalDeductions(basic);
    }
}