package org.hyperskill.linearEquationSolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@DisplayName("Should MatrixUtils methods work")
public class MatrixUtilsTest {

    @DisplayName("Should sort by equation length work")
    @ParameterizedTest(name = "{index} => expected={0}, matrix={1}")
    @MethodSource("sortByEquationLengthArgumentsProvider")
    void sortByEquationLength(Matrix expected, Matrix matrix) {
        assertEquals(expected, MatrixUtils.sortByEquationLength(matrix));
    }
    private static Stream<Arguments> sortByEquationLengthArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                        })
                                ))
                        ),
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        })
                                ))
                        )
                ),
                Arguments.of(
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(-3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, new Fraction(3, 5), Fraction.NEG_ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ONE
                                        })
                                ))
                        ),
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(-3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, new Fraction(3, 5), Fraction.NEG_ONE, Fraction.ONE
                                        })
                                ))
                        )
                ),
                Arguments.of(
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(-3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, new Fraction(3, 5), Fraction.NEG_ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                        })
                                ))
                        ),
                        new Matrix(
                                new ArrayList<Equation>(List.of(
                                        new Equation(new Fraction[]{
                                                Fraction.ONE, new Fraction(-3, 2), new Fraction(10, 3), Fraction.NEG_ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ONE, new Fraction(2, 3), new Fraction(-9, 1)
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, new Fraction(3, 5), Fraction.NEG_ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                        })
                                ))
                        )
                )
        );
    }
}
