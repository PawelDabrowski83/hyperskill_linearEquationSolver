package org.hyperskill.linearEquationSolver;

public class Fraction implements Comparable<Fraction>{

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction NEG_ONE = new Fraction(-1, 1);

    final long numerator;
    final long denominator;

    public Fraction(long numerator, long denominator) {
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
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Fraction{" + numerator + "/" + denominator + "}";
    }

    public Fraction reduce() {
        long gcd = FractionUtils.findGCD(numerator, denominator);
        long reducedNumerator = numerator / gcd;
        long reducedDenominator = denominator / gcd;

        return reducedDenominator == 1 && reducedNumerator == 1 ? Fraction.ONE :
                reducedDenominator == 1 && reducedNumerator == 0 ? Fraction.ZERO :
                reducedDenominator == 1 && reducedNumerator == -1 ? Fraction.NEG_ONE :
                new Fraction (reducedNumerator, reducedDenominator);
    }

    public Fraction pushUpMinus() {
        if (denominator >= 0) {
            return new Fraction(numerator, denominator);
        }
        return new Fraction(numerator * -1, denominator * -1);
    }

    public Fraction reduceZeroNumerator() {
        if (numerator == 0 || denominator == 0) {
            return Fraction.ZERO;
        }
        return this;
    }

    public Fraction roundUp() {
        long reducedNumerator = numerator;
        long reducedDenominator = denominator;
        while (reducedDenominator > 100_000 || reducedNumerator > 100_000) {
            if (reducedNumerator > 1_000 && reducedDenominator > 1_000) {
                reducedNumerator /= 1_000;
                reducedDenominator /= 1_000;
            } else if (reducedNumerator > 1_000) {
                reducedNumerator /= 1_000;
                reducedDenominator = 1;
            } else {
                reducedDenominator /= 1_000;
                reducedNumerator = 1;
            }
        }
        return new Fraction(reducedNumerator, reducedDenominator).reduce();
    }

    public Fraction findOpposite() {
        if (Fraction.ZERO.equals(this) || Fraction.ONE.equals(this) || Fraction.NEG_ONE.equals(this)) {
            return this;
        }
        return new Fraction(denominator, numerator).shape();
    }

    public Fraction shape() {
        return this.reduceZeroNumerator().pushUpMinus().roundUp().reduce();
    }

    public double getDecimal() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public int compareTo(Fraction fraction) {
        double comparison = this.getDecimal() - fraction.getDecimal();
        return comparison < 0 ? (int) Math.floor(comparison) : (int) Math.ceil(comparison);
    }
}
