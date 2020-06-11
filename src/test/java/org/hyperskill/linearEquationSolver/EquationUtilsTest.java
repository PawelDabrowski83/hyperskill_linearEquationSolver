package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationUtilsTest {

    Equation equation;
    Equation equation1;
    Equation equation2;
    Equation expected;
    Equation actual;

    @Test
    public void shouldAddEquationGiven1_2AndNeg3_6And1_7Plus1_4And9_2AndNeg8_3Returns() {
        // given
        equation1 = new Equation(new Fraction[]{new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)});
        equation2 = new Equation(new Fraction[]{new Fraction(1, 4), new Fraction(9, 2), new Fraction(-8, 3)});
        expected = new Equation(new Fraction[]{new Fraction(3, 4), new Fraction(4, 1), new Fraction(-53, 21)});

        // when
        actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_2AndNeg3_6And1_7Plus9_2AndNeg8_3Returns() {
        // given
        equation1 = new Equation(new Fraction[]{new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)});
        equation2 = new Equation(new Fraction[]{new Fraction(9, 2), new Fraction(-8, 3)});
        expected = new Equation(new Fraction[]{new Fraction(5, 1), new Fraction(-19, 6), new Fraction(1, 7)});

        // when
        actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_7AndNeg3_2AndNeg1_1Plus1_4AndNeg2_1And3_4Returns() {
        // given
        equation1 = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        equation2 = new Equation(new Fraction[]{new Fraction(1, 4), new Fraction(-2, 1), new Fraction(3, 4)});
        expected = new Equation(new Fraction[]{new Fraction(11, 28), new Fraction(-7, 2), new Fraction(-1, 4)});

        // when
        actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddEquationGiven1_7AndNeg3_2AndNeg1_1Plus0_1AndNeg2_1And0_1Returns() {
        // given
        equation1 = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        equation2 = new Equation(new Fraction[]{Fraction.ZERO, new Fraction(-2, 1), Fraction.ZERO});
        expected = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-7, 2), Fraction.NEG_ONE});

        // when
        actual = EquationUtils.addEquation(equation1, equation2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times1_1Returns() {
        // given
        equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = Fraction.ONE;
        expected = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});

        // when
        actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times0_1Returns() {
        // given

        equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = Fraction.ZERO;
        expected = new Equation(new Fraction[]{Fraction.ZERO, Fraction.ZERO, Fraction.ZERO});

        // when
        actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1TimesNeg2_3Returns() {
        // given
        equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = new Fraction(-2, 3);
        expected = new Equation(new Fraction[]{new Fraction(-2, 21), Fraction.ONE, new Fraction(2, 3)});

        // when
        actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2AndNeg1_1Times5_4Returns() {
        // given
        equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE});
        Fraction multiplier = new Fraction(5, 4);
        expected = new Equation(new Fraction[]{new Fraction(5, 28), new Fraction(-15, 8), new Fraction(-5, 4)});

        // when
        actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiplyEquationGiven1_7AndNeg3_2And0_1Times2_1Returns() {
        // given
        equation = new Equation(new Fraction[]{new Fraction(1, 7), new Fraction(-3, 2), Fraction.ZERO});
        Fraction multiplier = new Fraction(2, 1);
        expected = new Equation(new Fraction[]{new Fraction(2, 7), new Fraction(-3, 1), Fraction.ZERO});

        // when
        actual = EquationUtils.multiplyEquation(equation, multiplier);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven2_3And3_4AndNeg1_7And0_1And5_6Returns() {
        // given
        equation = new Equation(new Fraction[]{
                new Fraction(2, 3), new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
        });
        expected = new Equation(new Fraction[]{
                Fraction.ONE, new Fraction(9, 6), new Fraction(-3, 14), Fraction.ZERO, new Fraction(5, 4)
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven0_1And3_4AndNeg1_7And0_1And5_6Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ZERO, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
        });
        expected = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ONE, new Fraction(-4, 21), Fraction.ZERO, new Fraction(10, 9)
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven0_1And0_1AndNeg1_7And0_1And5_6Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
        });
        expected = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ZERO, new Fraction(-35, 6)
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven0_1And0_1And0_1And0_1And5_6Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(5, 6)
        });
        expected = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven0_1And0_1And0_1And0_1And0_1Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
        });
        expected = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven0_1And0_1And0_1And0_1And1_1Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
        });
        expected = new Equation(new Fraction[]{
                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeLeadingOneGiven1_1And3_4AndNeg1_7And0_1And5_6Returns() {
        // given
        equation = new Equation(new Fraction[]{
                Fraction.ONE, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
        });
        expected = new Equation(new Fraction[]{
                Fraction.ONE, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
        });

        // when
        actual = EquationUtils.makeLeadingOne();

        // then
        assertEquals(expected, actual);
    }
}
