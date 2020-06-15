package org.hyperskill.linearEquationSolver;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Matrix makeEquationsLeadingOne() {
        Matrix temp = new Matrix(new ArrayList<>());
        if (this.equations != null) {
            int counter = 0;
            while (counter < this.equations.size()) {
                temp.equations.add(EquationUtils.makeLeadingOne(this.equations.get(counter)));
                counter++;
            }
        }
        return temp;
    }

    public Matrix makeRowEchelon() {
        Matrix matrix = new Matrix(this.equations);
        matrix = MatrixUtils.sortByEquationLength(matrix.makeEquationsLeadingOne());
        int position = 0;
            for (int i = 1; i < matrix.equations.size(); i++) {
                if (position < matrix.equations.get(i).findLeadingPosition() && matrix.equations.get(i).findLeadingPosition() != -1) {
                    position = matrix.equations.get(i).findLeadingPosition();
                    continue;
                } else if (matrix.equations.get(i).findLeadingPosition() == -1) {
                    return matrix;
                } else {
                    Equation base = matrix.equations.get(i - 1);
                    Equation target = matrix.equations.get(i);
                    base = base.reduceEquivalentRows(target);
                    matrix.equations.add(i - 1, base);
                    matrix.equations.remove(i);
                    matrix = MatrixUtils.sortByEquationLength(matrix.makeEquationsLeadingOne());
                    i = 0;
                    position = 0;
                }
            }
        return matrix;
    }
}
