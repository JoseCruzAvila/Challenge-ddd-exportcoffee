package co.com.sofka.production.employee.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Salary implements ValueObject<Double> {
    private final double value;

    public Salary(double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salary that = (Salary) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
