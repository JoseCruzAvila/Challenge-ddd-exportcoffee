package co.com.sofka.production.dispatch.values;

import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Value object that contains the schedule info of a dispatch
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Schedule implements ValueObject<Map<String, Object>> {
    private final Set<Schedule.Days> days;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Schedule(Set<Schedule.Days> days, LocalTime startTime, LocalTime endTime) {
        this.days = Objects.requireNonNull(days);
        this.startTime = Objects.requireNonNull(startTime);
        this.endTime = Objects.requireNonNull(endTime);
    }

    /**
     * Enumeartion with the days of the week
     */
    public enum Days {
        MO, TU, WE, TH, FR, SA, SU
    }

    @Override
    public Map<String, Object> value() {
        return Map.of("Days", this.days, "StartAt", this.startTime, "EndAt", this.endTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule that = (Schedule) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
