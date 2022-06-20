package co.com.sofka.production.employee.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Address;

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
