package org.hyperskill.linearEquationSolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@DisplayName("Should EquationUtils - external methods for Equation class")
public class EquationUtilsTest {

    final EquationUtils equationUtils = new EquationUtils();

    @DisplayName("Should addEquation work")
    @ParameterizedTest(name = "{index} => expected={0}, equation1={1}, equation2={2}")
    @MethodSource("addEquationArgumentsProvider")
    void addEquation(Equation expected, Equation equation1, Equation equation2) {
        assertEquals(expected, EquationUtils.addEquation(equation1, equation2));
    }

    private static Stream<Arguments> addEquationArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(3, 4), new Fraction(4, 1), new Fraction(-53, 21)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 4), new Fraction(9, 2), new Fraction(-8, 3)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(5, 1), new Fraction(-19, 6), new Fraction(1, 7)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 2), new Fraction(-3, 6), new Fraction(1, 7)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(9, 2), new Fraction(-8, 3)
                        })

                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(11, 28), new Fraction(-7, 2), new Fraction(-1, 4)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 4), new Fraction(-2, 1), new Fraction(3, 4)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-7, 2), Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, new Fraction(-2, 1), Fraction.ZERO
                        })
                )
        );
    }

    @DisplayName("Should multiplyEquation work")
    @ParameterizedTest(name = "{index} => expected={0}, equation={1}, multiplier={2}")
    @MethodSource("multiplyEquationArgumentsProvider")
    void multiplyEquation(Equation expected, Equation equation, Fraction multiplier) {
        assertEquals(expected, EquationUtils.multiplyEquation(equation, multiplier));
    }
    private static Stream<Arguments> multiplyEquationArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        Fraction.ONE
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        Fraction.ZERO
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(-2, 21), Fraction.ONE, new Fraction(2, 3)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        new Fraction(-2, 3)
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(5, 28), new Fraction(-15, 8), new Fraction(-5, 4)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.NEG_ONE
                        }),
                        new Fraction(5, 4)
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                new Fraction(2, 7), new Fraction(-3, 1), Fraction.ZERO
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 7), new Fraction(-3, 2), Fraction.ZERO
                        }),
                        new Fraction(2, 1)
                )
        );
    }

    @DisplayName("Should makeLeadingOne transfer equation that leading entry is one")
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @MethodSource("makeLeadingOneArgumentsProvider")
    void makeLeadingOne(Equation expected, Equation equation) {
        assertEquals(expected, EquationUtils.makeLeadingOne(equation));
    }
    private static Stream<Arguments> makeLeadingOneArgumentsProvider(){
        return Stream.of(
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ONE, new Fraction(9, 8), new Fraction(-3, 14), Fraction.ZERO, new Fraction(5, 4)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(2, 3), new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ONE, new Fraction(-4, 21), Fraction.ZERO, new Fraction(10, 9)
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ZERO, new Fraction(-35, 6)
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, new Fraction(5, 6)
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
                        })
                ),
                Arguments.of(
                        new Equation(new Fraction[]{
                                Fraction.ONE, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ONE, new Fraction(3, 4), new Fraction(-1, 7), Fraction.ZERO, new Fraction(5, 6)
                        })
                )
        );
    }

    @DisplayName("Should EquationUtils compare() work")
    @ParameterizedTest(name = "{index} => expected={0}, equation1={1}, equation2={2}")
    @MethodSource("compareArgumentsProvider")
    void compare(int expected, Equation equation1, Equation equation2) {
        assertEquals(expected, equationUtils.compare(equation1, equation2));
    }
    private static Stream<Arguments> compareArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        0,
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        })
                ),
                Arguments.of(
                        1,
                        new Equation(new Fraction[]{
                                Fraction.ONE, Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        })
                ),
                Arguments.of(
                        1,
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE, Fraction.NEG_ONE
                        })
                ),
                Arguments.of(
                        0,
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        })
                ),
                Arguments.of(
                        1,
                        new Equation(new Fraction[]{
                                new Fraction(1, 3), new Fraction(2, 3), new Fraction(-1, 5)
                        }),
                        new Equation(new Fraction[]{
                                Fraction.ZERO, Fraction.NEG_ONE
                        })
                ),
                Arguments.of(
                        8,
                        new Equation(new Fraction[]{
                                new Fraction(1, 3), new Fraction(2, 3), new Fraction(-1, 5)
                        }),
                        new Equation(new Fraction[]{
                                new Fraction(1, 3), new Fraction(-20, 3), new Fraction(-1, 5)
                        })
                )
        );
    }

    @DisplayName("Should readSolution() from Equation work")
    @ParameterizedTest(name = "{index} => expected={0}, equation={1}")
    @MethodSource("readSolutionArgumentsProvider")
    void readSolution(double expected, Equation given) {
        assertEquals(expected, EquationUtils.readSolution(given), 0.1);
    }
    private static Stream<Arguments> readSolutionArgumentsProvider() {
        return Stream.of(
//                Arguments.of(1.0, new Equation(new Fraction[]{
//                        Fraction.ONE, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
//                })),
//                Arguments.of(-1.0, new Equation(new Fraction[]{
//                        Fraction.ZERO, Fraction.ONE, Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE
//                })),
//                Arguments.of(0, new Equation(new Fraction[]{
//                        Fraction.ZERO, new Fraction(2, 1), Fraction.ZERO, Fraction.ONE
//                })),
//                Arguments.of(1.0, new Equation(new Fraction[]{
//                        Fraction.ZERO, Fraction.ONE, Fraction.ONE
//                })),
//                Arguments.of(-1.0, new Equation(new Fraction[]{
//                        Fraction.ZERO, Fraction.ONE, Fraction.NEG_ONE
//                })),
//                Arguments.of(0, new Equation(new Fraction[]{
//                        Fraction.NEG_ONE, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE
//                })),
//                Arguments.of(9.0, new Equation(new Fraction[]{
//                        Fraction.ZERO, Fraction.ONE, Fraction.ZERO, Fraction.ZERO, new Fraction(9, 1)
//                })),
                Arguments.of(0, new Equation(new Fraction[]{
                        Fraction.ZERO, Fraction.ONE, Fraction.ZERO, Fraction.ONE, new Fraction(9, 1)
                }))
        );
    }


}
