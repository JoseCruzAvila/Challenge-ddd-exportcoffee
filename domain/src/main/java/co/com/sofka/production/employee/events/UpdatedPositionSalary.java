package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.Salary;

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
