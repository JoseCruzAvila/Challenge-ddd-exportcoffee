package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.Salary;

/**
 * Domain event for identify when the salary of a position has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedPositionSalary extends DomainEvent {
    private final Salary salary;

    public UpdatedPositionSalary(Salary salary) {
        super("production.employee.updatedpositionsalary");
        this.salary = salary;
    }

    public Salary getSalary() {
        return salary;
    }
}
