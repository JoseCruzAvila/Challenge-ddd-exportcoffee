package co.com.sofka.production.general.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the name of some object
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Name implements ValueObject<String> {
    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The name couldn't be empty");
        }

        if (this.value.length() < 4) {
            throw new IllegalArgumentException("The name must get more than 5 characters");
        }

        if (this.value.length() >= 100) {
            throw new IllegalArgumentException("The name must get less than 100 characters");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name that = (Name) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
