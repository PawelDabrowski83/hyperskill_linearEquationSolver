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
}
