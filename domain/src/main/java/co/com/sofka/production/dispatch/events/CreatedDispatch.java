package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.Schedule;

/**
 * Domain event for identify when a dispatch has been created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedDispatch extends DomainEvent {
    private final Schedule schedule;

    public CreatedDispatch(Schedule schedule) {
        super("production.dispatch.createddispatch");
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
