package org.hyperskill.linearEquationSolver;

import java.util.Arrays;

import static org.hyperskill.linearEquationSolver.FractionUtils.addFractions;

public class EquationUtils {

    public static Equation addEquation(Equation equation1, Equation equation2) {
        int longest = Math.max(equation1.getLength(), equation2.getLength());
        Equation result = new Equation(new Fraction[longest]);
        Arrays.fill(result.numbers, new Fraction(0, 1));
        int counter = 0;
        while (counter < longest) {
            if (equation1.getLength() > counter) {
                result.numbers[counter] = addFractions(result.numbers[counter], equation1.numbers[counter]);
            }
            if (equation2.getLength() > counter) {
                result.numbers[counter] = addFractions(result.numbers[counter], equation2.numbers[counter]);
            }
            counter++;
        }
        return result;
    }

    public static Equation multiplyEquation(Equation equation, Fraction multiplier) {

    }
}
