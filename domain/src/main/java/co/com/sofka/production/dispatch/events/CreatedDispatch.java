package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.dispatch.values.Schedule;

/**
 * Domain event for identify when a dispatch has been created
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class CreatedDispatch extends DomainEvent {
    private final DispatchId dispatchId;
    private final Schedule schedule;

    public CreatedDispatch(DispatchId dispatchId, Schedule schedule) {
        super("production.dispatch.createddispatch");
        this.dispatchId = dispatchId;
        this.schedule = schedule;
    }

    public DispatchId getDispatchId() {
        return dispatchId;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
