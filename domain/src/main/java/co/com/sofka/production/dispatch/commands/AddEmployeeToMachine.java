package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for add an employee to  machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class AddEmployeeToMachine extends Command {
    private final Employee employee;
    private final Name positionName;
    private final Description positionDescription;
    private final Salary salary;
    private final MachineId machineId;

    public AddEmployeeToMachine(Employee employee, Name positionName, Description positionDescription, Salary salary, MachineId machineId) {
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
