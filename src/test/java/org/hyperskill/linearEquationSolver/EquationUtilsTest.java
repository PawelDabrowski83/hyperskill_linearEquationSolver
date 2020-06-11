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
        Equation equation1 = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), new Fraction(-1, 1)});
        Equation equation2 = new Equation(new Fraction[]{new Fraction(1, 4), new Fraction(-2, 1), new Fraction(3, 4)});
        Equation expected = new Equation(new Fraction[]{new Fraction(11, 28), new Fraction(-7, 2), new Fraction(-1, 4)});

        // when
        Equation actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }
}
