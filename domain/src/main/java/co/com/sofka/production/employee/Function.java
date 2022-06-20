package co.com.sofka.production.employee;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * class that acts like a function for an employee inside the company
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class Function extends Entity<FunctionId> {
    private Name name;
    private Description description;

    public Function(FunctionId entityId, Name name, Description description) {
        super(entityId);
        this.name = name;
        this.description = description;
    }

    /**
     * Method that updated the function name
     * 
     * @param name the new name
     */
    protected void changeName(Name name) {
        this.name = name;
    }

    /**
     * Method that updates de function description
     * 
     * @param description the new description
     */
    protected void changeDescription(Description description) {
        this.description = description;
    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }
    
}
