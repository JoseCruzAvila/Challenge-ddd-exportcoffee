package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.general.values.Address;

/**
 * Class that acts like a command for update an employee address
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateAddressCommand extends Command {
    private final EmployeeId employeeId;
    private final Address address;

    public UpdateAddressCommand(EmployeeId entityId, Address address) {
        this.employeeId = entityId;
        this.address = address;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Address getFullname() {
        return address;
    }
}
