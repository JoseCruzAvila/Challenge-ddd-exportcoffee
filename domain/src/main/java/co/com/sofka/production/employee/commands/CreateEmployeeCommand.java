package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.general.values.Address;

public class CreateEmployeeCommand extends Command {
    private final EmployeeId employeeId;
    private final Fullname fullname;
    private final Address address;

    public CreateEmployeeCommand(EmployeeId entityId, Fullname fullname, Address address) {
        this.employeeId = entityId;
        this.fullname = fullname;
        this.address = address;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public Address getAddress() {
        return address;
    }
}
