package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionUtilsTest {

    @Test
    public void shouldFindGCDGiven4And2Return2() {
        // given
        int a = 4;
        int b = 2;
        int expected = 2;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindGCDGiven3And7Return21() {
        // given
        int a = 3;
        int b = 7;
        int expected = 1;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindGCDGiven14And7Return7() {
        // given
        int a = 14;
        int b = 7;
        int expected = 7;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindGCDGiven10And2Return2() {
        // given
        int a = 10;
        int b = 2;
        int expected = 2;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindGCDGiven8AndNeg2Return2() {
        // given
        int a = 8;
        int b = -2;
        int expected = 2;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindGCDGiven0AndNeg2Return0() {
        // given
        int a = 0;
        int b = -2;
        int expected = 1;

        // when
        int actual = FractionUtils.findGCD(a, b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven1_4And1_2Returns3_4() {
        // given
        Fraction fraction1 = new Fraction(1, 4);
        Fraction fraction2 = new Fraction(1, 2);
        Fraction expected = new Fraction(3, 4);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven3_4AndNeg1_4Returns1_2() {
        // given
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(-1, 4);
        Fraction expected = new Fraction(1, 2);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven5_7And1_2Returns17_14() {
        // given
        Fraction fraction1 = new Fraction(5, 7);
        Fraction fraction2 = new Fraction(1, 2);
        Fraction expected = new Fraction(17, 14);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven3_2And5_8Returns17_8() {
        // given
        Fraction fraction1 = new Fraction(3, 2);
        Fraction fraction2 = new Fraction(5, 8);
        Fraction expected = new Fraction(17, 8);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven1_5And3_6Returns3_30() {
        // given
        Fraction fraction1 = new Fraction(1, 5);
        Fraction fraction2 = new Fraction(3, 6);
        Fraction expected = new Fraction(7, 10);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven1_4And0_1Returns1_4() {
        // given
        Fraction fraction1 = new Fraction(1, 4);
        Fraction fraction2 = Fraction.ZERO;
        Fraction expected = new Fraction(1, 4);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven0_1And0_1Returns0_1() {
        // given
        Fraction fraction1 = Fraction.ZERO;
        Fraction fraction2 = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven0_1AndNeg8_1ReturnsNeg8_1() {
        // given
        Fraction fraction1 = Fraction.ZERO;
        Fraction fraction2 = new Fraction(-8, 1);
        Fraction expected = new Fraction(-8, 1);

        // when
        Fraction actual = FractionUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGiven3_5Times1_1Returns3_5() {
        // given
        Fraction fraction = new Fraction(3, 5);
        Fraction multiplier = new Fraction(1, 1);
        Fraction expected = new Fraction(3, 5);

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGiven3_5Times0_1Returns0_1() {
        // given
        Fraction fraction = new Fraction(3, 5);
        Fraction multiplier = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGiven0_1Times0_1Returns0_1() {
        // given
        Fraction fraction = Fraction.ZERO;
        Fraction multiplier = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGivenNeg4_5Times0_1Returns0_1() {
        // given
        Fraction fraction = new Fraction(-4, 5);
        Fraction multiplier = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGivenNeg4_5Times2_3ReturnsNeg8_15() {
        // given
        Fraction fraction = new Fraction(-4, 5);
        Fraction multiplier = new Fraction(2, 3);
        Fraction expected = new Fraction(-8, 15);

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGivenNeg4_5Times5_1ReturnsNeg4_1() {
        // given
        Fraction fraction = new Fraction(-4, 5);
        Fraction multiplier = new Fraction(5, 1);
        Fraction expected = new Fraction(-4, 1);

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyFractionsGivenNeg4_5TimesNeg10_1Returns8_1() {
        // given
        Fraction fraction = new Fraction(-4, 5);
        Fraction multiplier = new Fraction(-10, 1);
        Fraction expected = new Fraction(8, 1);

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldMultiplyFractionsGivenNullTimesNeg10_1ThrowsNPE() {
        // given
        Fraction fraction = null;
        Fraction multiplier = new Fraction(-10, 1);
        Fraction expected = null;

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldMultiplyFractionsGiven1_1TimesNullThrowsNPE() {
        // given
        Fraction fraction = new Fraction(1, 1);
        Fraction multiplier = null;
        Fraction expected = null;

        // when
        Fraction actual = FractionUtils.multiplyFractions(fraction, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGiven1_2Returns2_1() {
        // given
        Fraction fraction = new Fraction(1, 2);
        Fraction expected = new Fraction(2, 1);

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGivenNeg7_4ReturnsNeg4_7() {
        // given
        Fraction fraction = new Fraction(-7, 4);
        Fraction expected = new Fraction(-4, 7);

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGiven0_1Returns0_1() {
        // given
        Fraction fraction = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGiven0_12Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, 12);
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldFindOppositeGivenNullThrowsNPE() {
        // given
        Fraction fraction = null;
        Fraction expected = null;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }
}
