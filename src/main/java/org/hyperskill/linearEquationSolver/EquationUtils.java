package org.hyperskill.linearEquationSolver;

import java.util.Arrays;
import java.util.Comparator;

import static org.hyperskill.linearEquationSolver.FractionUtils.addFractions;
import static org.hyperskill.linearEquationSolver.FractionUtils.multiplyFractions;

public class EquationUtils implements Comparator<Equation> {

    protected final static FractionUtils fractionUtils = new FractionUtils();

    public static Equation addEquation(Equation equation1, Equation equation2) {
        int longest = Math.max(equation1.getLength(), equation2.getLength());
        Equation result = new Equation(new Fraction[longest]);
        Arrays.fill(result.numbers, Fraction.ZERO);
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
        return new Equation(
                Arrays.stream(equation.numbers)
                        .map(n -> multiplyFractions(n, multiplier))
                        .toArray(Fraction[]::new));
    }

    public static Equation makeLeadingOne(Equation equation) {
        return multiplyEquation(equation, equation.findLeadingEntry().findOpposite());
    }

    @Override
    public int compare(Equation e1, Equation e2) {
        if (e1.numbers == null) {
            e1.numbers = new Fraction[]{Fraction.ZERO};
        }
        if (e2.numbers == null) {
            e2.numbers = new Fraction[]{Fraction.ZERO};
        }
        Fraction[] fractions1 = Arrays.copyOf(e1.numbers, e1.numbers.length);
        Fraction[] fractions2 = Arrays.copyOf(e2.numbers, e2.numbers.length);
        fractions1 = getFractions(fractions1, fractions2);
        fractions2 = getFractions(fractions2, fractions1);
        return Arrays.compare(fractions1, fractions2);
    }

    private Fraction[] getFractions(Fraction[] fractions1, Fraction[] fractions2) {
        if (fractions1.length < fractions2.length) {
            Fraction[] temp = new Fraction[fractions2.length];
            Arrays.fill(temp, Fraction.ZERO);
            int counter = 0;
            for (Fraction f : fractions1) {
                temp[counter] = f;
                counter++;
            }
            fractions1 = temp;
        }
        return fractions1;
    }

    public static double readSolution(Equation equation) {
        if (Fraction.ONE.equals(equation.findLeadingEntry())) {
            int leadingPosition = equation.findLeadingPosition();
            if (leadingPosition == -1 || leadingPosition == equation.getLength()) {
                return 0;
            }
            int counter = 1;
            Fraction current = equation.numbers[leadingPosition + counter];
            while (Fraction.ZERO.equals(current) && leadingPosition + counter < equation.getLength() - 1) {
                counter++;
                current = equation.numbers[leadingPosition + counter];
            }
            if (leadingPosition + counter == equation.getLength() - 1) {
                return equation.numbers[equation.numbers.length - 1].getDecimal();
            }
        }
        return 0;
    }
}
