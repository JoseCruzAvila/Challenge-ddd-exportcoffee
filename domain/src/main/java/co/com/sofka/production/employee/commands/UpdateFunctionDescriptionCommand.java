package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;

public class UpdateFunctionDescriptionCommand extends Command {
    private final EmployeeId employeeId;
    private final FunctionId functionId;
    private final Description description;

    public UpdateFunctionDescriptionCommand(EmployeeId employeeId, FunctionId functionId, Description description) {
        this.employeeId = employeeId;
        this.functionId = functionId;
        this.description = description;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }

    public Description getDescription() {
        return description;
    }

}