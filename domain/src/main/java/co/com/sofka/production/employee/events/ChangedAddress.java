package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Address;

/**
 * Class that acts like an event when the address of a person is changed
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ChangedAddress extends DomainEvent {
    private final Address address;

    public ChangedAddress(Address address) {
        super("production.employee.changedaddress");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
