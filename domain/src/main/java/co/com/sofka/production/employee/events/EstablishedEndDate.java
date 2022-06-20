package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.EndDate;

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
