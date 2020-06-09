package org.hyperskill.linearEquationSolver;

public class MathUtils {

    public static int findGCD(int a, int b) {
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);
        if (num1 == 0 || num2 == 0) {
            return 1;
        }
        if (num1 == num2) {
            return num1;
        }
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return num2;
    }
}
