package com.calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Scientific Calculator");
        System.out.println("Choose operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Log");
        System.out.println("4. Power");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Enter number:");
                double x = scanner.nextDouble();
                System.out.println("Result: " + calc.squareRoot(x));
                break;

            case 2:
                System.out.println("Enter integer:");
                int n = scanner.nextInt();
                System.out.println("Result: " + calc.factorial(n));
                break;

            case 3:
                System.out.println("Enter number:");
                double y = scanner.nextDouble();
                System.out.println("Result: " + calc.naturalLog(y));
                break;

            case 4:
                System.out.println("Enter base:");
                double a = scanner.nextDouble();
                System.out.println("Enter exponent:");
                double b = scanner.nextDouble();
                System.out.println("Result: " + calc.power(a, b));
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}