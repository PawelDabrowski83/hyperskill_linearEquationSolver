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
        int a = this.numerator;
        int b = this.denominator;
        int gcd = MathUtils.findGCD(a, b);
        return new Fraction (a / gcd, b / gcd);
    }
}
