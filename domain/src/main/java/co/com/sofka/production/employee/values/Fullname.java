package co.com.sofka.production.employee.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the fullname info of an employee
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Fullname implements ValueObject<String> {
    private final String name;
    private final String lastname;

    public Fullname(String name, String lastname) {
        this.name = Objects.requireNonNull(name);
        this.lastname = Objects.requireNonNull(lastname);

        if (this.name.isBlank() || this.lastname.isBlank()) {
            throw new IllegalArgumentException("you must join your name and lastname");
        }

        if (this.name.length() >= 100 || this.lastname.length() >= 100) {
            throw new IllegalArgumentException("The name or lastname must get less than 100 characters");
        }
    }

    @Override
    public String value() {
        return this.name + " " + this.lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fullname that = (Fullname) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
    
}
