package co.com.sofka.production.general.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the description of some object
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Description implements ValueObject<String> {
    private final String value;

    public Description(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The description couldn't be empty");
        }

        if (this.value.length() < 5) {
            throw new IllegalArgumentException("The description must get more than 5 characters");
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

        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
