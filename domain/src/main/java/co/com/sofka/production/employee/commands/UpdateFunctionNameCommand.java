package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for update an employee function name
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateFunctionNameCommand extends Command {
    private final EmployeeId employeeId;
    private final FunctionId functionId;
    private final Name name;

    public UpdateFunctionNameCommand(EmployeeId employeeId, FunctionId functionId, Name name) {
        this.employeeId = employeeId;
        this.functionId = functionId;
        this.name = name;
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

}
