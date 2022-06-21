package co.com.sofka.production.dispatch.values;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the maintenance info of a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Maintenance implements ValueObject<Map<LocalDate, Double>> {
    private final LocalDate date;
    private final double cost;

    public Maintenance(LocalDate date, double cost) {
        this.date = Objects.requireNonNull(date);
        this.cost = Objects.requireNonNull(cost);

        if (this.date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The maintenance couldn't be programmed for a day before today");
        }

        if (this.cost <= 0) {
            throw new IllegalArgumentException("the maintenance must have a positive cost");
        }
    }

    @Override
    public Map<LocalDate, Double> value() {
        return Map.of(date, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maintenance that = (Maintenance) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
