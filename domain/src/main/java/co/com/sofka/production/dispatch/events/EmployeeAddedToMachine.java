package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when an employee is added for work in a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EmployeeAddedToMachine extends DomainEvent {
    private final EmployeeId employeeId;
    private final Fullname fullname;
    private final Address address;
    private final Name positionName;
    private final Description positionDescription;
    private final Salary salary;
    private final MachineId machineId;

    public EmployeeAddedToMachine(EmployeeId employeeId, Fullname fullname, Address address, Name positionName, Description positionDescription, Salary salary, MachineId machineId) {
        super("production.dispatch.employeeaddedtomachine");
        this.employeeId = employeeId;
        this.fullname = fullname;
        this.address = address;
        this.positionName = positionName;
        this.positionDescription = positionDescription;
        this.salary = salary;
        this.machineId = machineId;
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

    public Name getPositionName() {
        return positionName;
    }

    public Description getPositionDescription() {
        return positionDescription;
    }

    public Salary getSalary() {
        return salary;
    }

    public MachineId getMachineId() {
        return machineId;
    }

}
