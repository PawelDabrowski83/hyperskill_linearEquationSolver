package org.hyperskill.linearEquationSolver;

import org.junit.Test;

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

}
