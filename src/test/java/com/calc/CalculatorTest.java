package com.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    // ── Square Root Tests ──

    @Test
    void testSquareRoot() {
        assertEquals(4.0, calc.squareRoot(16));
    }

    @Test
    void testSquareRootOfZero() {
        assertEquals(0.0, calc.squareRoot(0));
    }

    @Test
    void testSquareRootNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.squareRoot(-1));
    }

    // ── Factorial Tests ──

    @Test
    void testFactorial() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, calc.factorial(1));
    }

    @Test
    void testFactorialNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
    }

    // ── Natural Log Tests ──

    @Test
    void testNaturalLog() {
        assertEquals(2.302585, calc.naturalLog(10), 0.0001);
    }

    @Test
    void testNaturalLogOfOne() {
        assertEquals(0.0, calc.naturalLog(1), 0.0001);
    }

    @Test
    void testNaturalLogNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.naturalLog(-5));
    }

    // ── Power Tests ──

    @Test
    void testPower() {
        assertEquals(8, calc.power(2, 3));
    }

    @Test
    void testPowerZeroExponent() {
        assertEquals(1, calc.power(2, 0));
    }

    @Test
    void testPowerNegativeExponent() {
        assertEquals(0.5, calc.power(2, -1), 0.0001);
    }
}