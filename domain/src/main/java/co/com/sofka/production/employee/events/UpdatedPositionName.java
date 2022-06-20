package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when the name of a position has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedPositionName extends DomainEvent {
    private final Name name;

    public UpdatedPositionName(Name name) {
        super("production.employee.updatedpositionname");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
