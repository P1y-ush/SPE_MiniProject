package com.calc;

public class Calculator {

    public double squareRoot(double x) {
        if (x < 0)
            throw new IllegalArgumentException("Negative input");
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Negative input");
        long result = 1;
        for (int i = 1; i <= x; i++)
            result *= i;
        return result;
    }

    public double naturalLog(double x) {
        if (x <= 0)
            throw new IllegalArgumentException("Invalid input");
        return Math.log(x);
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}