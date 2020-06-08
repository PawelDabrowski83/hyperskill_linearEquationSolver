package org.hyperskill.linearEquationSolver;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Course is giving me input via Scanner, I am passing data to external methods for testing
         */

        // { a * x + b * y = c
        // { d * x + e * y = f
        double aVar = 0;
        double bVar = 0;
        double cVar = 0;
        double dVar = 0;
        double eVar = 0;
        double fVar = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            aVar = scanner.nextDouble();
            bVar = scanner.nextDouble();
            cVar = scanner.nextDouble();
            dVar = scanner.nextDouble();
            eVar = scanner.nextDouble();
            fVar = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("incorrect input");
        }
        try {
            double result = solveLinear(aVar, bVar);
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

    public static double[] solveTwoSimultaneousLinears(double aVar, double bVar, double cVar, double dVar, double eVar
            , double fVar) {
        // { a * x + b * y = c
        // { d * x + e * y = f

        double y = (fVar - cVar * dVar / aVar) / (eVar - bVar * dVar / aVar);
        double x = (cVar - bVar * y) / aVar;
        return new double[]{x, y};

    }
}
