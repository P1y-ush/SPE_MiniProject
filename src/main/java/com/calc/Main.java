package com.calc;

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("sqrt <number>");
            System.out.println("fact <number>");
            System.out.println("log <number>");
            System.out.println("pow <base> <exponent>");
            return;
        }

        try {
            switch (args[0]) {

                case "sqrt":
                    System.out.println("Result: " +
                            calc.squareRoot(Double.parseDouble(args[1])));
                    break;

                case "fact":
                    System.out.println("Result: " +
                            calc.factorial(Integer.parseInt(args[1])));
                    break;

                case "log":
                    System.out.println("Result: " +
                            calc.naturalLog(Double.parseDouble(args[1])));
                    break;

                case "pow":
                    System.out.println("Result: " +
                            calc.power(
                                    Double.parseDouble(args[1]),
                                    Double.parseDouble(args[2])));
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}