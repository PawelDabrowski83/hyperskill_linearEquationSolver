package org.hyperskill.linearEquationSolver;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainTest {

    @DisplayName("Should checkCommandLine() work")
    @ParameterizedTest(name = "{index} => expected={0}, input={1}")
    @MethodSource("checkCommandLineArgumentsProvider")
    void checkCommandLine(String[] expected, String[] input) {
        assertArrayEquals(expected, Main.checkCommandLine(input));
    }
    private static Stream<Arguments> checkCommandLineArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"in.txt", "out.txt"},
                        new String[]{"-in", "in.txt", "-out", "out.txt"}
                ),
                Arguments.of(
                        new String[]{"input.txt", "output.txt"},
                        new String[]{"-out", "output.txt", "-in", "input.txt"}
                ),
                Arguments.of(
                        new String[]{"", ""},
                        new String[]{"input.txt", "in", "out", "output.txt"}
                ),
                Arguments.of(
                        new String[]{"", ""},
                        new String[]{""}
                ),
                Arguments.of(
                        new String[]{"", ""},
                        new String[0]
                )
        );
    }

    @DisplayName("Should checkCommandLine() receive null, it returns array with empty strings")
    @ParameterizedTest(name = "{index} => expected=null, actual={0}")
    @NullAndEmptySource
    void checkCommandLine(String[] text) {
        assertArrayEquals(new String[]{"", ""}, Main.checkCommandLine(text));
    }
}
