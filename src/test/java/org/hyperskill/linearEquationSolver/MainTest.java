package org.hyperskill.linearEquationSolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldSolveLinearWork() {
        assertEquals(0.6, Main.solveLinear(5, 3), 0.1);
        assertEquals(0.5, Main.solveLinear(8, 4), 0.1);
        assertEquals(0, Main.solveLinear(22, 0), 0.1);
    }

    @Test (expected = ArithmeticException.class)
    public void shouldGivenDividerZeroThrowArithmeticException() {
        // when
        double actual = Main.solveLinear(0, 17);
        // then
        // throws exception
    }

    @Test
    public void shouldSolveTwoSimultaneousLinearsWork1() {
        String expected = "0,85714 0,71429";
        double[] actualResult = Main.solveTwoSimultaneousLinears(4, 5 , 7, 3, 9, 9);
        String actual = String.format("%.5f %.5f", actualResult[0], actualResult[1]);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSolveTwoSimultaneousLinearsWork2() {
        String expected = "-1,00000 2,00000";
        double[] actualResult = Main.solveTwoSimultaneousLinears(1, 2, 3, 4, 5, 6);
        String actual = String.format("%.5f %.5f", actualResult[0], actualResult[1]);
        assertEquals(expected, actual);
    }

}
