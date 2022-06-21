package co.com.sofka.production.warehouse.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the info about the status of a coffe bag
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Status implements ValueObject<Status.Current> {
    private final Current value;

    public Status(Status.Current value) {
        this.value = Objects.requireNonNull(value);
    }

    public enum Current {
        NOTREAT, TOAST, GRIND
    }

    @Override
    public Current value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status that = (Status) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
