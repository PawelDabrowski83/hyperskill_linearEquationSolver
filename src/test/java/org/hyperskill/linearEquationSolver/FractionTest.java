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

@DisplayName("Should Fraction methods work")
public class FractionTest {

    @DisplayName("Should Fraction reduce() returns lowest equivalent Fraction")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(ReduceArgumentProvider.class)
    void reduce(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.reduce());
    }

    static class ReduceArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Fraction(1, 2), new Fraction(1, 2)),
                    Arguments.of(new Fraction(1, 2), new Fraction(2, 4)),
                    Arguments.of(new Fraction(5, 1), new Fraction(100, 20)),
                    Arguments.of(new Fraction(1, 2), new Fraction(13, 26)),
                    Arguments.of(new Fraction(3, 4), new Fraction(3, 4)),
                    Arguments.of(new Fraction(3, 4), new Fraction(6, 8))
                    );
        }
    }

    @DisplayName("Should Fraction pushUpMinus() assure that minus is only on upper part")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(PushUpMinusArgumentProvider.class)
    void pushUpMinus(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.pushUpMinus());
    }

    static class PushUpMinusArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Fraction(-1, 2), new Fraction(-1, 2)),
                    Arguments.of(new Fraction(-1, 2), (new Fraction(1, -2)),
                    Arguments.of(new Fraction(1, 2), new Fraction(-1, -2)),
                    Arguments.of(new Fraction(0, 2), new Fraction(0, -2))
            ));
        }
    }


    @DisplayName("Should Fraction reduceZeroNumerator() assure that all zero fractions are Fraction.ZERO")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(ReduceZeroNumeratorArgumentProvider.class)
    void reduceZeroNumerator(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.reduceZeroNumerator());
    }

    static class ReduceZeroNumeratorArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(Fraction.ZERO, new Fraction(0, 0)),
                    Arguments.of(Fraction.ZERO, new Fraction(0, 10)),
                    Arguments.of(Fraction.ZERO, new Fraction(0, 8)),
                    Arguments.of(Fraction.ZERO, new Fraction(0, -8)),
                    Arguments.of(Fraction.ZERO, new Fraction(-8, 0))
            );
        }
    }
}
