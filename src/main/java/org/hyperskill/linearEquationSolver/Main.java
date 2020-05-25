package org.hyperskill.linearEquationSolver;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Course is giving me input via Scanner, I am passing data to external methods for testing
         */

        // equation a * x = b
        double a = 0;
        double b = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("incorrect input");
        }
        try {
            double result = solveLinear(a, b);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
    public static double solveLinear (double a, double b) throws ArithmeticException {
        // equation a * x = b
        if (a == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return b / a;
    }
}
