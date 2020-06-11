package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationUtilsTest {

    @Test
    public void shouldAddEquationGiven1_2AndNeg3_6And1_7Plus1_4And9_2AndNeg8_3Returns() {
        // given
        Equation equation1 = new Equation(new Fraction[]{new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)});
        Equation equation2 = new Equation(new Fraction[]{new Fraction(1, 4), new Fraction(9, 2), new Fraction(-8, 3)});
        Equation expected = new Equation(new Fraction[]{new Fraction(3, 4), new Fraction(4, 1), new Fraction(-53, 21)});

        // when
        Equation actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_2AndNeg3_6And1_7Plus9_2AndNeg8_3Returns() {
        // given
        Equation equation1 = new Equation(new Fraction[]{new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)});
        Equation equation2 = new Equation(new Fraction[]{new Fraction(9, 2), new Fraction(-8, 3)});
        Equation expected = new Equation(new Fraction[]{new Fraction(5, 1), new Fraction(-19, 6), new Fraction(1, 7)});

        // when
        Equation actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_7AndNeg3_2AndNeg1_1Plus1_4AndNeg2_1And3_4Returns() {
        // given
        Equation equation1 = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Equation equation2 = new Equation(new Fraction[]{new Fraction(1, 4), new Fraction(-2, 1), new Fraction(3, 4)});
        Equation expected = new Equation(new Fraction[]{new Fraction(11, 28), new Fraction(-7, 2), new Fraction(-1, 4)});

        // when
        Equation actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_7AndNeg3_2AndNeg1_1Plus0_1AndNeg2_1And0_1Returns() {
        // given
        Equation equation1 = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Equation equation2 = new Equation(new Fraction[]{Fraction.ZERO, new Fraction(-2, 1), Fraction.ZERO});
        Equation expected = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-7, 2), Fraction.NEG_ONE});

        // when
        Equation actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times1_1Returns() {
        // given
        Equation equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = Fraction.ONE;
        Equation expected = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});

        // when
        Equation actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times0_1Returns() {
        // given

        Equation equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = Fraction.ZERO;
        Equation expected = new Equation(new Fraction[]{Fraction.ZERO, Fraction.ZERO, Fraction.ZERO});

        // when
        Equation actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1TimesNeg2_3Returns() {
        // given
        Equation equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = new Fraction(-2, 3);
        Equation expected = new Equation(new Fraction[]{new Fraction(-2, 21), Fraction.ONE, new Fraction(-2, 3)});

        // when
        Equation actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times5_4Returns() {
        // given
        Equation equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = new Fraction(5, 4);
        Equation expected = new Equation(new Fraction[]{new Fraction(5, 28), new Fraction(-15, 8), new Fraction(-5, 4)});

        // when
        Equation actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2And0_1Times2_1Returns() {
        // given
        Equation equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.ZERO});
        Fraction multiplier = new Fraction(2, 1);
        Equation expected = new Equation(new Fraction[]{new Fraction(2, 7), new Fraction(-3, 1), Fraction.ZERO});

        // when
        Equation actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }
}
