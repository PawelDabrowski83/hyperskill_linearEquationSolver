package org.hyperskill.linearEquationSolver;

public class MatrixUtils {

    public static Matrix sortByEquationLength(Matrix matrix) {
        matrix.equations.sort(new EquationUtils().reversed());
        return matrix;
    }
}
