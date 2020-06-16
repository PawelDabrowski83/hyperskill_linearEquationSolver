package org.hyperskill.linearEquationSolver;

import java.util.ArrayList;

public class MatrixUtils {

    public static Matrix sortByEquationLength(Matrix matrix) {
        matrix.equations.sort(new EquationUtils().reversed());
        return matrix;
    }

    public static Matrix convertIntArrayToMatrix(int[][] source) {
        Matrix matrix = new Matrix(new ArrayList<>());
        if (source != null) {
            for (int[] row : source) {
                Equation equation = new Equation(new Fraction[row.length]);
                int counter = 0;
                for (int i : row) {
                    equation.numbers[counter] = FractionUtils.convertIntToFraction(i);
                    counter++;
                }
                matrix.equations.add(equation);
            }
        }
        return matrix;
    }

    public static int[][] convertInputToIntArray(String input) {
        if (input == null || input.isEmpty()) {
            return new int[0][0];
        }
        String[] rows = input.split("\\n+");
        int[][] result = new int[rows.length][rows[0].split("\\s+").length];
        int rowCounter = 0;
        for (String row : rows) {
            int counter = 0;
            String[] numbersAsString = rows[rowCounter].split("\\s+");
            for (String str : numbersAsString) {
                result[rowCounter][counter] = Integer.parseInt(str);
                counter++;
            }
            rowCounter++;
        }

        return result;
    }
}
