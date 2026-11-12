package employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SalaryCalculatorTest {

    private final SalaryCalculator calc = new SalaryCalculator();

    @Test
    void testHRA() {
        assertEquals(10000, calc.calculateHRA(50000), 0.01);
    }

    @Test
    void testDA() {
        assertEquals(5000, calc.calculateDA(50000), 0.01);
    }

    @Test
    void testGrossSalary() {
        // 50000 + 10000 + 5000 = 65000, so 70000 is wrong on purpose
        assertEquals(70000, calc.calculateGross(50000), 0.01);
    }

    @Test
    void testDeductionsWithIncomeTax() {
        // PF 6000 + PT 200 + tax 6500 (gross 65000 > 50000)
        assertEquals(12700, calc.calculateTotalDeductions(50000), 0.01);
    }

    @Test
    void testNetSalaryWithoutIncomeTax() {
        // gross 39000, PF 3600, PT 200, tax 0 -> net 35200
        assertEquals(35200, calc.calculateNet(30000), 0.01);
    }

    @Test
    void testNegativeBasicThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateGross(-1));
    }
}