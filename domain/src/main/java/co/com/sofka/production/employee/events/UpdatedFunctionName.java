package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Name;

public class UpdatedFunctionName extends DomainEvent {
    private final FunctionId functionId;
    private final Name name;

    public UpdatedFunctionName(FunctionId entityId, Name name) {
        super("production.employee.updatedfunctionname");
        this.functionId = entityId;
        this.name = name;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }

    public Name getName() {
        return name;
    }
}
