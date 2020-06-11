package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationTest {

    @Test
    public void shouldIsEmptyGiven1_2And3_4And0_1ReturnsFalse() {
        // given
        Equation equation = new Equation(new Fraction[]{new Fraction(1, 2), new Fraction(3, 4), Fraction.ZERO});
        boolean expected = false;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyGiven0_1And0_1And0_1ReturnsTrue() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.ZERO, Fraction.ZERO, Fraction.ZERO});
        boolean expected = true;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyGiven1_1And0_1And1_1ReturnsFalse() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.ONE, Fraction.ZERO, Fraction.ONE});
        boolean expected = false;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyGivenNeg1_1And0_1AndNeg1_1ReturnsFalse() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.NEG_ONE, Fraction.ZERO, Fraction.NEG_ONE});
        boolean expected = false;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyGiven0_1And0_1And1_1ReturnsFalse() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.ZERO, Fraction.ZERO, Fraction.ONE});
        boolean expected = false;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldIsEmptyGivenNullReturnsNPE() {
        // given
        Equation equation = null;
        boolean expected = false;

        // when
        boolean actual = equation.isEmpty();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingEntryGiven1_1And0_1And4_5AndNeg8_1Returns1_1() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ONE, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)});
        Fraction expected = Fraction.ONE;

        // when
        Fraction actual = equation.findLeadingEntry();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingEntryGiven0_1And0_1And4_5AndNeg8_1Returns4_5() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)});
        Fraction expected = new Fraction(4, 5);

        // when
        Fraction actual = equation.findLeadingEntry();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingEntryGiven0_1And0_1And0_1AndNeg8_1ReturnsNeg8_1() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(-8, 1)});
        Fraction expected = new Fraction(-8, 1);

        // when
        Fraction actual = equation.findLeadingEntry();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingEntryGiven0_1And0_1And0_1And0_1Returns0_1() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO});
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = equation.findLeadingEntry();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven2_3And1_1And0_1And9_2AndNeg1_1Returns0() {
        // given
        Equation equation = new Equation(new Fraction[]{
                new Fraction(2, 3), Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE});
        int expected = 0;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven0_1And1_1And0_1And9_2AndNeg1_1Returns1() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE});
        int expected = 1;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven0_1And0_1And0_1And9_2AndNeg1_1Returns3() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE});
        int expected = 3;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven0_1And0_1And0_1And0_1AndNeg1_1Returns4() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE});
        int expected = 4;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven0_1And0_1And0_1And0_1And0_1ReturnsNeg1() {
        // given
        Equation equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO});
        int expected = -1;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGivenEmptyReturnsNeg1() {
        // given
        Equation equation = new Equation(new Fraction[0]);
        int expected = -1;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven0_1ReturnsNeg1() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.ZERO});
        int expected = -1;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLeadingPositionGiven1_1Returns0() {
        // given
        Equation equation = new Equation(new Fraction[]{Fraction.ONE});
        int expected = 0;

        // when
        int actual = equation.findLeadingPosition();

        // then
        assertEquals(expected, actual);
    }

}
