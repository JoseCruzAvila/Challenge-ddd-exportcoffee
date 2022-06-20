package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;

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
