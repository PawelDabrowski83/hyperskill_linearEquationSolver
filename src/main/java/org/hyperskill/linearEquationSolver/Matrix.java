package org.hyperskill.linearEquationSolver;

import java.util.List;

public class Matrix {

    List<Equation> equations;

    public Matrix(List<Equation> equations) {
        this.equations = equations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;

        Matrix matrix = (Matrix) o;

        return equations.equals(matrix.equations);
    }

    @Override
    public int hashCode() {
        return equations.hashCode();
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "equations=" + equations +
                '}';
    }
}
