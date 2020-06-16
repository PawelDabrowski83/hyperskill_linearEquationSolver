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

    public Matrix makeReducedEchelonForm() {
        Matrix temp = new Matrix(new ArrayList<>(this.equations));
        if (this.equations != null && temp.equations.size() > 1) {
            for (int i = 1; i < temp.equations.size(); i++) {
                int leadingPosition = temp.equations.get(i).findLeadingPosition();
                if (leadingPosition != -1) {
                    for (int j = 0; j < temp.equations.size(); j++) {
                        if (j != i && temp.equations.get(j).getLength() >= leadingPosition) {
                            Fraction toReduce = temp.equations.get(j).numbers[leadingPosition];
                            toReduce = FractionUtils.multiplyFractions(toReduce, Fraction.NEG_ONE);
                            if (!Fraction.ZERO.equals(toReduce)) {
                                Equation reductor = EquationUtils.multiplyEquation(temp.equations.get(i), toReduce);
                                Equation reduced = EquationUtils.addEquation(temp.equations.get(j), reductor);
                                temp.equations.add(j, reduced);
                                temp.equations.remove(j + 1);
                            }
                        }
                    }

                }
            }
        }
        return temp;
    }
}
