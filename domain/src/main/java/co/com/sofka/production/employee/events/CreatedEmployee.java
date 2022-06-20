package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;

/**
 * Domain event for identify when a user has been created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedEmployee extends DomainEvent {
    private final Fullname fullname;
    private final Address address;
    private final StartDate startDate; 

    public CreatedEmployee(Fullname fullname, Address address, StartDate startDate) {
        super("production.employee.createdemployee");
        this.fullname = fullname;
        this.address = address;
        this.startDate = startDate;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public Address getAddress() {
        return address;
    }

    public StartDate getStartDate() {
        return startDate;
    }
    
}
