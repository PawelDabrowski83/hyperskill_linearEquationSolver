package org.hyperskill.linearEquationSolver;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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

    public boolean isEmpty() {
        return Arrays.asList(new Fraction[]{Fraction.ZERO}).containsAll(Arrays.asList(this.numbers));
    }

    public Fraction findLeadingEntry() {
        return Arrays.stream(this.numbers)
                .filter(n -> !n.equals(Fraction.ZERO))
                .findFirst()
                .orElse(Fraction.ZERO);
    }

    public int findLeadingPosition() {
        AtomicInteger i = new AtomicInteger();
        return Arrays.stream(this.numbers)
                .peek(v -> i.incrementAndGet())
                .anyMatch(n -> n.equals(findLeadingEntry())) ? i.get() - 1 : -1;
    }

}
