package org.hyperskill.linearEquationSolver;

public class Fraction {

    final int numerator;
    final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    @Override
    public String toString() {
        return "Fraction{" + numerator + "/" + denominator + "}";
    }

    public Fraction reduce() {
        int gcd = FractionUtils.findGCD(numerator, denominator);
        return new Fraction (numerator / gcd, denominator / gcd);
    }

    public Fraction pushUpMinus() {
        if (denominator >= 0) {
            return new Fraction(numerator, denominator);
        }
        return new Fraction(numerator * -1, denominator * -1);
    }

    public Fraction reduceZeroNumerator() {
        if (numerator == 0 || denominator == 0) {
            return new Fraction(0, 1);
        }
        return this;
    }

    public Fraction shape() {
        return this.reduceZeroNumerator().pushUpMinus().reduce();
    }
}
