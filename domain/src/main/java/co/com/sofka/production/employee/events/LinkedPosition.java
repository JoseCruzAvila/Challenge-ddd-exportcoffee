package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.PositionId;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when a position has been created and associated with an employee
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class LinkedPosition extends DomainEvent {
    private final PositionId positionId;
    private final Name name;
    private final Description description;
    private final Salary salary;

    public LinkedPosition(PositionId entityId, Name name, Description description, Salary salary) {
        super("production.employee.linkedposition");
        this.positionId = entityId;
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    public PositionId getPositionId() {
        return positionId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Salary getSalary() {
        return salary;
    }
}
