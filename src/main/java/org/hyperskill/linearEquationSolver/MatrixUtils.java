package org.hyperskill.linearEquationSolver;

import java.util.ArrayList;
import java.util.List;

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
}
