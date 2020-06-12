package org.hyperskill.linearEquationSolver;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@DisplayName("Should Equation work")
public class EquationTest {

    @DisplayName("Should Equation.isEmpty() work")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(IsEmptyArgumentsProvider.class)
    void isEmpty(boolean expected, Equation equation) {
        assertEquals(expected, equation.isEmpty());
    }

    static class IsEmptyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(false, new Equation(new Fraction[]{
                            new Fraction(1, 2), new Fraction(3, 4), Fraction.ZERO
                    })),
                    Arguments.of(true, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ONE, Fraction.ZERO, Fraction.ONE
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.NEG_ONE, Fraction.ZERO, Fraction.NEG_ONE
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                    }))
            );
        }
    }

    @Test (expected = NullPointerException.class)
    public void shouldIsEmptyGivenNullReturnsNPE() {
        assertFalse(new Equation(null).isEmpty());
    }

    @DisplayName("Should Equation.findLeadingEntry() work")
    @ParameterizedTest(name = "{index} => expected={0}, equation={1}")
    @ArgumentsSource(FindLeadingEntryArgumentsProvider.class)
    void findLeadingEntry(Fraction expected, Equation equation) {
        assertEquals(expected, equation.findLeadingEntry());
    }

    static class FindLeadingEntryArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(Fraction.ONE, new Equation(new Fraction[]{
                            Fraction.ONE, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)
                    })),
                    Arguments.of(new Fraction(4, 5), new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)
                    })),
                    Arguments.of(new Fraction(-8, 1), new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(-8, 1)
                    })),
                    Arguments.of(Fraction.ZERO, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                    }))
            );
        }
    }

    @DisplayName("Should Equation.findLeadingPosition() return number with non-zero fraction in equation")
    @ParameterizedTest(name = "{index} => expected={0}, equation={1}")
    @ArgumentsSource(FindLeadingPositionArgumentsProvider.class)
    void findLeadingPosition(int expected, Equation equation) {
        assertEquals(expected, equation.findLeadingPosition());
    }

    static class FindLeadingPositionArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(0, new Equation(new Fraction[]{
                            new Fraction(2, 3), Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE
                    })),
                    Arguments.of(2, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)
                    })),
                    Arguments.of(3, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(-8, 1)
                    })),
                    Arguments.of(-1, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                    })),
                    Arguments.of(1, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE
                    })),
                    Arguments.of(3, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE
                    })),
                    Arguments.of(4, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE
                    })),
                    Arguments.of(-1, new Equation(new Fraction[0])),
                    Arguments.of(-1, new Equation(new Fraction[]{Fraction.ZERO})),
                    Arguments.of(0, new Equation(new Fraction[]{Fraction.NEG_ONE}))
            );
        }
    }

    @DisplayName("Should Equation.isLeadingOne() work")
    @ParameterizedTest(name = "{index} => expected={0}, equation={1}")
    @ArgumentsSource(IsLeadingOneArgumentsProvider.class)
    void isLeadingOne(boolean expected, Equation equation) {
        assertEquals(expected, equation.isLeadingOne());
    }

    static class IsLeadingOneArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(false, new Equation(new Fraction[]{
                            new Fraction(2, 3), Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, new Fraction(4, 5), new Fraction(-8, 1)
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(-8, 1)
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                    })),
                    Arguments.of(true, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ONE, Fraction.ZERO, new Fraction(9, 2), Fraction.NEG_ONE
                    })),
                    Arguments.of(false, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE
                    })),
                    Arguments.of(false, new Equation(new Fraction[0])),
                    Arguments.of(false, new Equation(new Fraction[]{Fraction.ZERO})),
                    Arguments.of(false, new Equation(new Fraction[]{Fraction.NEG_ONE})),
                    Arguments.of(true, new Equation(new Fraction[]{
                            Fraction.ONE, new Fraction(2, 3), new Fraction(-5, 2), Fraction.ONE
                    })),
                    Arguments.of(true, new Equation(new Fraction[]{
                            Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                    }))
            );
        }
    }

    @Test (expected = NullPointerException.class)
    public void shouldIsLeadingOneGivenNullThrowsNPE() {
        assertFalse(new Equation(null).isLeadingOne());
    }
}
