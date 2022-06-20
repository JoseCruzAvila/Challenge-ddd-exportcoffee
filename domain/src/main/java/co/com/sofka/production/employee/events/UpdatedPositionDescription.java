package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Description;

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
