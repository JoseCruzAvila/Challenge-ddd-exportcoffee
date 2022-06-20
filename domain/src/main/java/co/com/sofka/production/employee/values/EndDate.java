package co.com.sofka.production.employee.values;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class EndDate implements ValueObject<Map<LocalDate, String>> {
    private final LocalDate endDate;
    private final String reason;

    public EndDate(LocalDate endDate, String reason) {
        this.endDate = Objects.requireNonNull(endDate);
        this.reason = Objects.requireNonNull(reason);

        if (this.reason.isBlank()) {
            throw new IllegalArgumentException("You must give a reason for the end of the employee contract");
        }
    }

    @Override
    public Map<LocalDate, String> value() {
        return Map.of(endDate, reason);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EndDate that = (EndDate) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
    
}
