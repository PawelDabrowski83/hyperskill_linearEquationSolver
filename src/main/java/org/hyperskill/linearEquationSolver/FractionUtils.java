package org.hyperskill.linearEquationSolver;

public class FractionUtils {

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

    public static Fraction addFractions(Fraction fraction1, Fraction fraction2) {
        if (fraction1.denominator == fraction2.denominator) {
            return new Fraction(fraction1.numerator + fraction2.numerator,
                    fraction1.denominator).shape();
        }
        if (fraction1.denominator % fraction2.denominator == 0 || fraction2.denominator % fraction1.denominator == 0) {
            int divider;
            if (fraction1.denominator > fraction2.denominator) {
                divider = fraction1.denominator / fraction2.denominator;
                return new Fraction(fraction1.numerator + fraction2.numerator * divider,
                        fraction1.denominator).shape();
            } else {
                divider = fraction2.denominator / fraction1.denominator;
                return new Fraction(fraction2.numerator + fraction1.numerator * divider,
                        fraction2.denominator).shape();
            }
        } else {
            return new Fraction(
                    fraction1.numerator * fraction2.denominator + fraction2.numerator * fraction1.denominator,
                    fraction1.denominator * fraction2.denominator).shape();
        }
    }

    public static Fraction multiplyFractions(Fraction fraction, Fraction multiplier) {
        return new Fraction(
                fraction.numerator * multiplier.numerator,
                fraction.denominator * multiplier.denominator)
                .shape();
    }

    public static Fraction convertIntToFraction(int number) {
        return new Fraction(number, 1).shape();
    }

}
