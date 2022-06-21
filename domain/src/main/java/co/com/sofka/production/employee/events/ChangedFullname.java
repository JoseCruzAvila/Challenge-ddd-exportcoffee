package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.Fullname;

/**
 * Class that acts like an event when the fullname of an employee is changed
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ChangedFullname extends DomainEvent {
    private final Fullname fullname;

    public ChangedFullname(Fullname fullname) {
        super("production.employee.changedfullname");
        this.fullname = fullname;
    }

    public Fullname getFullname() {
        return fullname;
    }

}
