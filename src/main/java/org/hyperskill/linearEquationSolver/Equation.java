package org.hyperskill.linearEquationSolver;


import java.util.Arrays;

public class Equation {
    Fraction[] numbers;

    public Equation(Fraction[] numbers) {
         this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equation)) return false;

        Equation equation = (Equation) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(numbers, equation.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    @Override
    public String toString() {
        return "Equation{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public int getLength() {
        return numbers.length;
    }
}
