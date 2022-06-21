package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;

/**
 * Domain event for identify when the description of a function has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedFunctionDescription extends DomainEvent {
    private final FunctionId functionId;
    private final Description description;

    public UpdatedFunctionDescription(FunctionId entityId, Description description) {
        super("production.employee.updatedfunctionname");
        this.functionId = entityId;
        this.description = description;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }

    public Description getDescription() {
        return description;
    }
}
