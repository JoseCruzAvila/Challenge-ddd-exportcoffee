package co.com.sofka.production.employee;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.employee.values.PositionId;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Class that make reference to the position of an employee inside the company
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Position extends Entity<PositionId> {
    private Name name;
    private Description description;
    private Salary salary;
    
    public Position(PositionId entityId, Name name, Description description, Salary salary) {
        super(entityId);
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    protected void changeName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    protected void changeDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    } 

    protected void changeSalary(Salary salary) {
        this.salary = Objects.requireNonNull(salary);
    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }

    public Salary salary() {
        return salary;
    }

}
