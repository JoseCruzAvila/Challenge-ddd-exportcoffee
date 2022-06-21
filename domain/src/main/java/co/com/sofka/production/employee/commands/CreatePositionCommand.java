package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.PositionId;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for create a position
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatePositionCommand extends Command {
    private final PositionId positionId;
    private final Name name;
    private final Description description;
    private final Salary salary;

    public CreatePositionCommand(PositionId entityId, Name name, Description description, Salary salary) {
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
