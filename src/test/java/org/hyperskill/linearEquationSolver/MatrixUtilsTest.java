package org.hyperskill.linearEquationSolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
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
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ONE, Fraction.ONE
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                        }),
                                        new Equation(new Fraction[]{
                                                Fraction.ZERO, Fraction.ZERO, Fraction.NEG_ONE, Fraction.ONE
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

    @DisplayName("Should convertIntArrayToMatrix work")
    @ParameterizedTest(name = "{index} => expected={0}, intArray={1}")
    @MethodSource("convertIntArrayToMatrixArgumentsProvider")
    void convertIntArrayToMatrix(Matrix expected, int[][] source) {
        assertEquals(expected, MatrixUtils.convertIntArrayToMatrix(source));
    }
    private static Stream<Arguments> convertIntArrayToMatrixArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(2, 1), new Fraction(3, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(2, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ZERO
                                })
                        )),
                        new int[][]{
                                new int[]{
                                        1, 2, 3
                                },
                                new int[]{
                                        0, 1, 2
                                },
                                new int[]{
                                        0, 0, 0
                                }
                        }
                ),
                Arguments.of(
                        new Matrix(List.of(
                                new Equation(new Fraction[]{
                                        Fraction.ONE, new Fraction(3, 1), Fraction.ZERO, new Fraction(2, 1), new Fraction(7, 1)
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ONE, new Fraction(5, 1), Fraction.ONE, Fraction.ZERO
                                }),
                                new Equation(new Fraction[]{
                                        Fraction.ZERO, Fraction.ZERO, Fraction.ZERO, Fraction.ONE, new Fraction(2, 1)
                                })
                        )),
                        new int[][]{
                                new int[]{
                                        1, 3, 0, 2, 7
                                },
                                new int[]{
                                        0, 1, 5, 1, 0
                                },
                                new int[]{
                                        0, 0, 0, 1, 2
                                }
                        }
                ),
                Arguments.of(
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
                        )),
                        new int[][]{
                                new int[]{
                                        1, 2, 3, 4
                                },
                                new int[]{
                                        2, 3, 4, 5
                                },
                                new int[]{
                                        3, 4, 5, 6
                                }
                        }
                ),
                Arguments.of(
                        new Matrix(Collections.emptyList()),
                        new int[0][0]
                )
        );
    }

    @DisplayName("Should convertInputToIntArray work")
    @ParameterizedTest(name = "{index} => expected={0}, string={1}")
    @MethodSource("convertInputToIntArrayArgumentsProvider")
    void convertInputToIntArray(int[][] expected, String provided) {
        assertArrayEquals(expected, MatrixUtils.convertInputToIntArray(provided));
    }
    private static Stream<Arguments> convertInputToIntArrayArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{
                                        1, 2, 3
                                },
                                new int[]{
                                        0, 1, 2
                                },
                                new int[]{
                                        0, 0, 1
                                }
                        },
                        "1 2 3" + System.lineSeparator() +
                        "0 1 2" + System.lineSeparator() +
                        "0 0 1"
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{
                                        1, 0, -1
                                },
                                new int[]{
                                        0, 1, 2
                                },
                                new int[]{
                                        0, 0, 0
                                }
                        },
                        "1 0 -1" + System.lineSeparator() +
                        "0 1 2" + System.lineSeparator() +
                        "0 0 0"
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{
                                        -1, 0, 1
                                },
                                new int[]{
                                        -2, 17, 555
                                }
                        },
                        "-1 0 1" + System.lineSeparator() +
                        "-2 17 555"
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{
                                        1, 3, 0, 2, 7, -2
                                },
                                new int[]{
                                        0, 1, 5, -1, 0, 0
                                },
                                new int[]{
                                        0, 0, 0, 1, 11, 2
                                },
                                new int[]{
                                        -15, 0, 9, -2, 3, 0
                                },
                                new int[]{
                                        1, 2, 3, 0, 1, 2
                                }
                        },
                        "1 3 0 2 7 -2" + System.lineSeparator() +
                        "0 1 5 -1 0 0" + System.lineSeparator() +
                        "0 0 0 1 11 2" + System.lineSeparator() +
                        "-15 0 9 -2 3 0" + System.lineSeparator() +
                        "1 2 3 0 1 2"
                )
        );
    }


}
