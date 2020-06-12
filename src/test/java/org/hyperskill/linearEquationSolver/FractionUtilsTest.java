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
import static org.junit.Assert.assertNull;

@DisplayName("Should FractionUtils methods work")
public class FractionUtilsTest {

    @DisplayName("Should FractionUtils findGCD() return greatest common divider")
    @ParameterizedTest(name = "{index} => expected={0}, a={1}, b={2}")
    @ArgumentsSource(FindGCDArgumentsProvider.class)
    void findGCD(int expected, int a, int b) {
        assertEquals(expected, FractionUtils.findGCD(a, b));
    }

    static class FindGCDArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(2, 4, 2),
                    Arguments.of(1, 3, 7),
                    Arguments.of(7, 14, 7),
                    Arguments.of(2, 10, 2),
                    Arguments.of(2, 8, -2),
                    Arguments.of(1, 0, -2)
            );
        }
    }

    @DisplayName("Should FractionUtils addFractions work")
    @ParameterizedTest(name = "{index} => expected={0}, fraction1={1}, fraction2={2}")
    @ArgumentsSource(AddFractionsArgumentsProvider.class)
    void addFractions(Fraction expected, Fraction fraction1, Fraction fraction2) {
        assertEquals(expected, FractionUtils.addFractions(fraction1, fraction2));
    }

    static class AddFractionsArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Fraction(3, 4), new Fraction(1, 2), new Fraction(1, 4)),
                    Arguments.of(new Fraction(1, 2), new Fraction(3, 4), new Fraction(-1, 4)),
                    Arguments.of(new Fraction(17, 14), new Fraction(5, 7), new Fraction(1, 2)),
                    Arguments.of(new Fraction(17, 8), new Fraction(3, 2), new Fraction(5, 8)),
                    Arguments.of(new Fraction(7, 10), new Fraction(1, 5), new Fraction(3, 6)),
                    Arguments.of(new Fraction(1, 4), Fraction.ZERO, new Fraction(1, 4)),
                    Arguments.of(Fraction.ZERO, Fraction.ZERO, Fraction.ZERO),
                    Arguments.of(Fraction.ZERO, Fraction.ONE, Fraction.NEG_ONE),
                    Arguments.of(new Fraction(-8, 1), Fraction.ZERO, new Fraction(-8, 1))
            );
        }
    }

    @DisplayName("Should FractionUtils multiplyFractions work")
    @ParameterizedTest(name = "{index} => expected={0}, fraction1={1}, fraction2={2}")
    @ArgumentsSource(MultiplyFractionsArgumentsProvider.class)
    void multiplyFractions(Fraction expected, Fraction fraction1, Fraction fraction2) {
        assertEquals(expected, FractionUtils.multiplyFractions(fraction1, fraction2));
    }

    static class MultiplyFractionsArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Fraction(3, 5), Fraction.ONE, new Fraction(3, 5)),
                    Arguments.of(Fraction.ZERO, Fraction.ZERO, new Fraction(3, 5)),
                    Arguments.of(Fraction.ZERO, Fraction.ZERO, Fraction.ZERO),
                    Arguments.of(Fraction.ZERO, Fraction.ZERO, new Fraction(-4, 5)),
                    Arguments.of(new Fraction(-8, 15), new Fraction(-4, 5), new Fraction(2, 3)),
                    Arguments.of(new Fraction(-4, 1), new Fraction(-4, 5), new Fraction(5, 1)),
                    Arguments.of(new Fraction(8, 1), new Fraction(-4, 5), new Fraction(-10, 1)),
                    Arguments.of(new Fraction(2, 3), Fraction.ONE, new Fraction(2, 3)),
                    Arguments.of(new Fraction(-2, 3), Fraction.NEG_ONE, new Fraction(2, 3)),
                    Arguments.of(Fraction.ONE, Fraction.NEG_ONE, Fraction.NEG_ONE)
            );
        }
    }

    @Test (expected = NullPointerException.class)
    public void shouldMultiplyFractionsGivenNullTimesNeg10_1ThrowsNPE() {
        assertNull(FractionUtils.multiplyFractions(new Fraction(-10,3), null));
    }

    @Test (expected = NullPointerException.class)
    public void shouldMultiplyFractionsGiven1_1TimesNullThrowsNPE() {
        assertNull(FractionUtils.multiplyFractions(null, Fraction.ONE));
    }



    @Test
    public void shouldFindOppositeGiven1_2Returns2_1() {
        // given
        Fraction fraction = new Fraction(1, 2);
        Fraction expected = new Fraction(2, 1);

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGivenNeg7_4ReturnsNeg4_7() {
        // given
        Fraction fraction = new Fraction(-7, 4);
        Fraction expected = new Fraction(-4, 7);

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGiven0_1Returns0_1() {
        // given
        Fraction fraction = Fraction.ZERO;
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOppositeGiven0_12Returns0_1() {
        // given
        Fraction fraction = new Fraction(0, 12);
        Fraction expected = Fraction.ZERO;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldFindOppositeGivenNullThrowsNPE() {
        // given
        Fraction fraction = null;
        Fraction expected = null;

        // when
        Fraction actual = FractionUtils.findOpposite(fraction);

        // then
        assertEquals(expected, actual);
    }
}
