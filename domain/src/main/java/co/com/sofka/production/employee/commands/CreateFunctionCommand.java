package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for createa function
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateFunctionCommand extends Command {
    private final EmployeeId employeeId;
    private final FunctionId functionId;
    private final Name name;
    private final Description description;

    public CreateFunctionCommand(EmployeeId employeeId, FunctionId entityId, Name name, Description description) {
        this.employeeId = employeeId;
        this.functionId = entityId;
        this.name = name;
        this.description = description;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
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
