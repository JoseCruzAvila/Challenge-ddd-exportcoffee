package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.Schedule;

/**
 * Domain event for identify when the dispatch schedule has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ScheduleModified extends DomainEvent {
    private final Schedule schedule;

    public ScheduleModified(Schedule schedule) {
        super("production.dispatch.schedulemodified");
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
