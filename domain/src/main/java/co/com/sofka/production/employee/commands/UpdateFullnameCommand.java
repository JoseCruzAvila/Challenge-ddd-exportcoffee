package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;

/**
 * Class that acts like a command for update an employee fullname
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateFullnameCommand extends Command {
    private final EmployeeId employeeId;
    private final Fullname fullname;

    public UpdateFullnameCommand(EmployeeId entityId, Fullname fullname) {
        this.employeeId = entityId;
        this.fullname = fullname;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Fullname getFullname() {
        return fullname;
    }
}
