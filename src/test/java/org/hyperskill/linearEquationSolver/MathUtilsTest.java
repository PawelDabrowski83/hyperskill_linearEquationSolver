package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    @Test
    public void shouldFindGCDGiven4And2Return2() {
        // given
        int a = 4;
        int b = 2;
        int expected = 2;

        // when
        int actual = MathUtils.findGCD(a, b);

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
        int actual = MathUtils.findGCD(a, b);

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
        int actual = MathUtils.findGCD(a, b);

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
        int actual = MathUtils.findGCD(a, b);

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
        int actual = MathUtils.findGCD(a, b);

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
        int actual = MathUtils.findGCD(a, b);

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
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

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
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

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
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

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
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

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
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven1_4And0_1Returns1_4() {
        // given
        Fraction fraction1 = new Fraction(1, 4);
        Fraction fraction2 = new Fraction(0, 1);
        Fraction expected = new Fraction(1, 4);

        // when
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven0_1And0_1Returns0_1() {
        // given
        Fraction fraction1 = new Fraction(0, 1);
        Fraction fraction2 = new Fraction(0, 1);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddFractionsGiven0_1AndNeg8_1ReturnsNeg8_1() {
        // given
        Fraction fraction1 = new Fraction(0, 1);
        Fraction fraction2 = new Fraction(-8, 1);
        Fraction expected = new Fraction(-8, 1);

        // when
        Fraction actual = MathUtils.addFractions(fraction1, fraction2);

        // then
        assertEquals(expected, actual);
    }
}
