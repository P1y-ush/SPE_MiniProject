package com.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testSquareRoot() {
        assertEquals(4.0, calc.squareRoot(16));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(2.302585, calc.naturalLog(10), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(8, calc.power(2,3));
    }
}