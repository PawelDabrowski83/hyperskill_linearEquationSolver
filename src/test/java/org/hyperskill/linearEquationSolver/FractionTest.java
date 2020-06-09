package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    @Test
    public void shouldReduceGiven1_2Returns1_2() {
        // given
        Fraction fraction = new Fraction(1, 2);
        Fraction expected = new Fraction(1, 2);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceGiven2_4Returns1_2() {
        // given
        Fraction fraction = new Fraction(2, 4);
        Fraction expected = new Fraction(1, 2);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceGiven100_20Returns5_1() {
        // given
        Fraction fraction = new Fraction(100, 20);
        Fraction expected = new Fraction(5, 1);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceGiven13_26Returns1_2() {
        // given
        Fraction fraction = new Fraction(13, 26);
        Fraction expected = new Fraction(1, 2);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceGiven3_4Returns3_4() {
        // given
        Fraction fraction = new Fraction(3, 4);
        Fraction expected = new Fraction(3, 4);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceGiven6_8Returns3_4() {
        // given
        Fraction fraction = new Fraction(6, 8);
        Fraction expected = new Fraction(3, 4);

        // when
        Fraction actual = fraction.reduce();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPushUpMinusGivenNeg1_2ReturnsNeg1_2() {
        // given
        Fraction fraction = new Fraction(-1, 2);
        Fraction expected = new Fraction(-1, 2);

        // when
        Fraction actual = fraction.pushUpMinus();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPushUpMinusGiven1_Neg2ReturnsNeg1_2() {
        // given
        Fraction fraction = new Fraction(1, -2);
        Fraction expected = new Fraction(-1, 2);

        // when
        Fraction actual = fraction.pushUpMinus();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPushUpMinusGivenNeg1_Neg2Returns1_2() {
        // given
        Fraction fraction = new Fraction(-1, -2);
        Fraction expected = new Fraction(1, 2);

        // when
        Fraction actual = fraction.pushUpMinus();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPushUpMinusGiven0_Neg2Returns0_2() {
        // given
        Fraction fraction = new Fraction(0, -2);
        Fraction expected = new Fraction(0, 2);

        // when
        Fraction actual = fraction.pushUpMinus();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceZeroNumeratorGiven0_0Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, 0);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = fraction.reduceZeroNumerator();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceZeroNumeratorGiven0_10Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, 10);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = fraction.reduceZeroNumerator();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceZeroNumeratorGiven0_8Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, 8);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = fraction.reduceZeroNumerator();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceZeroNumeratorGivenNeg8_0Returns0_1() {
        // given
        Fraction fraction = new Fraction(-8, 0);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = fraction.reduceZeroNumerator();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceZeroNumeratorGiven0_Neg8Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, -8);
        Fraction expected = new Fraction(0, 1);

        // when
        Fraction actual = fraction.reduceZeroNumerator();

        // then
        assertEquals(expected, actual);
    }
}
