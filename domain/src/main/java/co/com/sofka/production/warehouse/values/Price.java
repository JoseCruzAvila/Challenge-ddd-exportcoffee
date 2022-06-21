package co.com.sofka.production.warehouse.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the info about the price of a coffee bag
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Price implements ValueObject<Double> {
    private final double value;

    public Price(double value) {
        this.value = Objects.requireNonNull(value);

        if (this.value <= 0) {
            throw new IllegalArgumentException("The Price of the coffee bag must be greater than 0");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price that = (Price) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
