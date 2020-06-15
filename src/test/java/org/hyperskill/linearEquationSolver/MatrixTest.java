package org.hyperskill.linearEquationSolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @DisplayName("Should makeEquationsLeadingOne() make all equations start with 1")
    @ParameterizedTest(name = "{index} => expected={0}, matrix={1}")
    @MethodSource("makeEquationsLeadingOneArgumentsProvider")
    void makeEquationsLeadingOne(Matrix expected, Matrix source) {
        assertEquals(expected, source.makeEquationsLeadingOne());
    }
    private static Stream<Arguments> makeEquationsLeadingOneArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(16, 5), new Fraction(-8, 1), new Fraction(16, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ZERO, new Fraction(7, 3), new Fraction(77, 6)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(3, 2), Fraction.ZERO, new Fraction(-3, 7)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(-5, 4), new Fraction(-15, 16), new Fraction(-5, 28)
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        new Fraction(1, 8), new Fraction(2, 5), Fraction.NEG_ONE, new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(3, 7), Fraction.ZERO, Fraction.ONE, new Fraction(11, 2)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(-2, 3), Fraction.NEG_ONE, Fraction.ZERO, new Fraction(2, 7)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(-4, 5), Fraction.ONE, new Fraction(3, 4), new Fraction(1, 7)
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(2, 27), new Fraction(-1, 18)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ONE, new Fraction(2, 89), new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(-4, 3), new Fraction(-8, 9), new Fraction(4, 15)
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, new Fraction(9, 1), new Fraction(2, 3), new Fraction(-1, 2)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ONE, new Fraction(2, 89), new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(3, 4), Fraction.NEG_ONE, new Fraction(-2, 3), new Fraction(1, 5)
                                })
                        ))
                )

        );
    }

    @DisplayName("Should makeRowEchelon matrix")
    @ParameterizedTest(name = "{index} => expected={0}, matrix={1}")
    @MethodSource("makeRowEchelonArgumentsProvider")
    void makeRowEchelon(Matrix expected, Matrix source) {
        assertEquals(expected, source.makeRowEchelon());
    }
    private static Stream<Arguments> makeRowEchelonArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.NEG_ONE, new Fraction(5, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.NEG_ONE
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.NEG_ONE, new Fraction(5, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.ONE, new Fraction(3, 1)
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ZERO, new Fraction(-1, 3), new Fraction(2, 3)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(1, 9), new Fraction(4, 27)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ONE, new Fraction(-1, 15)
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        new Fraction(3, 1), Fraction.ZERO, Fraction.NEG_ONE, new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(7, 1), new Fraction(4, 1), new Fraction(2, 1), new Fraction(5, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(2, 1), new Fraction(5, 1), Fraction.ONE, new Fraction(2, 1)
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ONE, Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ONE, Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.ONE, Fraction.ONE
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, Fraction.ONE, Fraction.ONE
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ONE, new Fraction(2, 1)
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ONE, new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1)
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE
                                })
                        ))
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(4, 3), new Fraction(5, 3), new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                })
                        )),
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(2, 1), new Fraction(3, 1), new Fraction(4, 1), new Fraction(5, 1)
                                }),
                                new Equation(new Fraction[]{
                                        new Fraction(3, 1), new Fraction(4, 1), new Fraction(5, 1), new Fraction(6, 1)
                                })
                        ))
                )
        );
    }
}
