package co.com.sofka.production.dispatch.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the quantity of coffe bags trated for a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class TreatCoffeeCount implements ValueObject<Integer> {
    private final int value;

    public TreatCoffeeCount(int value) {
        this.value = Objects.requireNonNull(value);

        if (this.value <= 0) {
            throw new IllegalArgumentException("the quantity of trated coffe must be at least 1");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatCoffeeCount that = (TreatCoffeeCount) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
}
