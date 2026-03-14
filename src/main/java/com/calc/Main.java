package com.calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {

            System.out.println("\nHello and Welcome to Scientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log");
            System.out.println("4. Power");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            // Check if input is available
            if(!scanner.hasNextInt()){
                System.out.println("Waiting for input...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result: " + calculator.squareRoot(num));
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    int factNum = scanner.nextInt();
                    System.out.println("Result: " + calculator.factorial(factNum));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double logNum = scanner.nextDouble();
                    System.out.println("Result: " + calculator.naturalLog(logNum));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + calculator.power(base, exp));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}