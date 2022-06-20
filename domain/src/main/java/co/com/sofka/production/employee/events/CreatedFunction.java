package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when an employee function has been created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedFunction extends DomainEvent {
    private final FunctionId functionId;
    private final Name name;
    private final Description description;

    public CreatedFunction(FunctionId entityId, Name name, Description description) {
        super("production.employee.createdfunction");
        this.functionId = entityId;
        this.name = name;
        this.description = description;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }
}
