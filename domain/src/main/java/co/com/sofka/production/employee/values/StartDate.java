package co.com.sofka.production.employee.values;

import java.time.LocalDate;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object for store the start date of an employee
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class StartDate implements ValueObject<LocalDate> {
    private final LocalDate value;

    public StartDate() {
        this.value = LocalDate.now();
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StartDate that = (StartDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
