package org.hyperskill.linearEquationSolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@DisplayName("Should Fraction methods work")
public class FractionTest {

    @DisplayName("Should Fraction reduce() returns lowest equivalent Fraction")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(ReduceArgumentsProvider.class)
    void reduce(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.reduce());
    }

    static class ReduceArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Fraction(1, 2), new Fraction(1, 2)),
                    Arguments.of(new Fraction(1, 2), new Fraction(2, 4)),
                    Arguments.of(new Fraction(5, 1), new Fraction(100, 20)),
                    Arguments.of(new Fraction(1, 2), new Fraction(13, 26)),
                    Arguments.of(new Fraction(3, 4), new Fraction(3, 4)),
                    Arguments.of(new Fraction(3, 4), new Fraction(6, 8)),
                    Arguments.of(Fraction.ZERO, new Fraction(0, 1)),
                    Arguments.of(Fraction.ONE, new Fraction(1, 1)),
                    Arguments.of(Fraction.NEG_ONE, new Fraction(-1, 1))

                    );
        }
    }

    @DisplayName("Should Fraction reduce() returns same objects")
    @ParameterizedTest(name = "{index} => expected={0}, actual{1}")
    @MethodSource("reduceSameArgumentsProvider")
    void reduceSame(Fraction expected, Fraction actual) {
        assertSame(expected, actual.reduce());
    }
    private static Stream<Arguments> reduceSameArgumentsProvider() {
        return Stream.of(
                Arguments.of(Fraction.ZERO, new Fraction(0, 1)),
                Arguments.of(Fraction.ONE, new Fraction(1, 1)),
                Arguments.of(Fraction.NEG_ONE, new Fraction(-1, 1))
        );
    }

    @DisplayName("Should roundUp() work")
    @ParameterizedTest(name = "{index} => expected={0}, source={1}")
    @MethodSource("roundUpArgumentsProvider")
    void roundUp(Fraction expected, Fraction source) {
        assertEquals(expected, source.roundUp());
    }
    private static Stream<Arguments> roundUpArgumentsProvider() {
        return Stream.of(
                Arguments.of(new Fraction(1, 418), new Fraction(2_357_101, 836_541_279)),
                Arguments.of(new Fraction(1_001, 90_000), new Fraction(1_001_001, 90_000_000)),
                Arguments.of(new Fraction(1, 89_234), new Fraction(1, 89_234_290)),
                Arguments.of(new Fraction(928, 1), new Fraction(928_132, 803)),
                Arguments.of(new Fraction(928, 1), new Fraction(928_132, 3))
        );
    }

    @DisplayName("Should Fraction pushUpMinus() assure that minus is only on upper part")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(PushUpMinusArgumentsProvider.class)
    void pushUpMinus(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.pushUpMinus());
    }

    static class PushUpMinusArgumentsProvider implements ArgumentsProvider {
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
    @ArgumentsSource(ReduceZeroNumeratorArgumentsProvider.class)
    void reduceZeroNumerator(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.reduceZeroNumerator());
    }

    static class ReduceZeroNumeratorArgumentsProvider implements ArgumentsProvider {
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

    @DisplayName("Should Fraction findOpposite() return valid fraction")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @ArgumentsSource(FindOppositeArgumentsProvider.class)
    void findOpposite(Fraction expected, Fraction actual) {
        assertEquals(expected, actual.findOpposite());
    }

    static class FindOppositeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(Fraction.ZERO, Fraction.ZERO),
                    Arguments.of(Fraction.ONE, Fraction.ONE),
                    Arguments.of(Fraction.NEG_ONE, Fraction.NEG_ONE),
                    Arguments.of(new Fraction(2, 3), new Fraction(3, 2)),
                    Arguments.of(Fraction.ZERO, new Fraction(-8, 0)),
                    Arguments.of(Fraction.ZERO, new Fraction(0, -8)),
                    Arguments.of(new Fraction(-1, 2), new Fraction(-2, 1)),
                    Arguments.of(new Fraction(-5, 1), new Fraction(-2, 10))
            );
        }
    }

    @DisplayName("Should compareTo() work")
    @ParameterizedTest(name = "{index} => expected={0}, fraction1={1}, fraction2={2}")
    @MethodSource("compareArgumentsProvider")
    void compare(int expected, Fraction fraction1, Fraction fraction2) {
        assertEquals(expected, fraction1.compareTo(fraction2));
    }
    private static Stream<Arguments> compareArgumentsProvider() {
        return Stream.of(
                Arguments.of(0, Fraction.ONE, Fraction.ONE),
                Arguments.of(2, Fraction.ONE, Fraction.NEG_ONE),
                Arguments.of(-1, Fraction.ZERO, Fraction.ONE),
                Arguments.of(1, new Fraction(1, 2), new Fraction(1, 4)),
                Arguments.of(-1, new Fraction(1, 4), new Fraction(3, 4)),
                Arguments.of(1, new Fraction(1, 13), new Fraction(1, 25))
        );
    }


}
