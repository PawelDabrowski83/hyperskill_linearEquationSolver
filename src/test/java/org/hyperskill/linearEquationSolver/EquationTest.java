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

}
