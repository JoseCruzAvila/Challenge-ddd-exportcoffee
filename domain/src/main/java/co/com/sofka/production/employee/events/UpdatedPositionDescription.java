package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Description;

/**
 * Domain event for identify when the description of a position has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedPositionDescription extends DomainEvent {
    private final Description description;

    public UpdatedPositionDescription(Description description) {
        super("production.employee.updatedpositiondescription");
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }
}
