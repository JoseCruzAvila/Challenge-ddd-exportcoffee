package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when an employee is added for work in a machine
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class EmployeeAddedToMachine extends DomainEvent {
    private final Employee employee;
    private final Name positionName;
    private final Description positionDescription;
    private final Salary salary;
    private final MachineId machineId;

    public EmployeeAddedToMachine(Employee employee, Name positionName, Description positionDescription, Salary salary, MachineId machineId) {
        super("production.dispatch.employeeaddedtomachine");
        this.employee = employee;
        this.positionName = positionName;
        this.positionDescription = positionDescription;
        this.salary = salary;
        this.machineId = machineId;
    }

    public Employee getEmployee() {
        return employee;
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
