package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

public class CreateFunctionCommand extends Command {
    private final FunctionId functionId;
    private final Name name;
    private final Description description;

    public CreateFunctionCommand(FunctionId entityId, Name name, Description description) {
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
