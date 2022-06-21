package co.com.sofka.production.dispatch.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the existent types of a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Type implements ValueObject<Type.Machine> {
    private final Type.Machine value;

    public Type(Type.Machine value) {
        this.value = Objects.requireNonNull(value);
    }
    
    /**
     * Enumeration with the machine types
     */
    public enum Machine {
        TOAST, GRIND
    }

    @Override
    public Machine value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type that = (Type) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
