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
 * @version 2.0
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

    /**
     * Method that updates the position name
     * 
     * @param name the new name
     */
    protected void changeName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Method that updates the position description
     * 
     * @param description the new description
     */
    protected void changeDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    } 

    /**
     * Method that updates the position salary
     * 
     * @param salary the new salary
     */
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
