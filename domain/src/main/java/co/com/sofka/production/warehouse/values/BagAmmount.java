package co.com.sofka.production.warehouse.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the info about the bag amount that company bought to a provider
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class BagAmmount implements ValueObject<Integer> {
    private final int value;

    public BagAmmount(int value) {
        this.value = Objects.requireNonNull(value);

        if (this.value < 0) {
            throw new IllegalArgumentException("the BagAmmount of the warehouse must be positive");
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

        BagAmmount that = (BagAmmount) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
