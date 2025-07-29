import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testPlus() {
        assertEquals(2147483646, calculator.plus.apply(-1, Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, calculator.plus.apply(2147483646, 1));
        assertEquals(28, calculator.plus.apply(10, 18));
    }

    @Test
    public void testMinus() {
        assertEquals(Integer.MIN_VALUE, calculator.minus.apply(-1, Integer.MAX_VALUE));
        assertEquals(-2147483646, calculator.minus.apply(1, Integer.MAX_VALUE));
        assertEquals(-94, calculator.minus.apply(1, 95));
    }

    @Test
    public void testMultiply() {
        assertEquals(319788, calculator.multiply.apply(987, 324));
        assertEquals(4341696, calculator.multiply.apply(135678, 32));
        assertEquals(736, calculator.multiply.apply(32, 23));
    }

    @Test
    public void testDivide() {
        assertEquals(9, calculator.divide.apply(18, 2));
        assertEquals(20, calculator.divide.apply(20, 1));
        assertEquals(3, calculator.divide.apply(9, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide.apply(10, 0));
    }

    @Test
    public void testPow() {
        assertEquals(0, calculator.pow.apply(0));
        assertEquals(400, calculator.pow.apply(-20));
        assertEquals(9, calculator.pow.apply(3));
    }

    @Test
    public void testAbs() {
        assertEquals(905757, calculator.abs.apply(-905757));
        assertEquals(0, calculator.abs.apply(0));
        assertEquals(264756, calculator.abs.apply(264756));

    }

    @Test
    public void testIsPositive() {
        assertTrue(calculator.isPositive.test(55));
        assertFalse(calculator.isPositive.test(-965));
        assertFalse(calculator.isPositive.test(0));
    }
}