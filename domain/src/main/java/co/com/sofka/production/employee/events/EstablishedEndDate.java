package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.EndDate;

/**
 * Domain event for identify when an employee end date has been updated or established
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EstablishedEndDate extends DomainEvent {
    private final EndDate endDate;

    public EstablishedEndDate(EndDate endDate) {
        super("production.employee.establishedenddate");
        this.endDate = endDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}
