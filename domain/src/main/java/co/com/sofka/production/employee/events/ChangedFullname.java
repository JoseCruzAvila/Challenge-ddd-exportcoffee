package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.Fullname;

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
