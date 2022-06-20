package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.general.values.Address;

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
