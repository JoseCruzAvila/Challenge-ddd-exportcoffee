package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Address;

/**
 * Domain event for identify when a client address is updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedClientAddress extends DomainEvent {
    private final ClientId clientId;
    private final Address address;

    public UpdatedClientAddress(ClientId clientId, Address address) {
        super("production.dispatch.updatedclientAddress");
        this.clientId = clientId;
        this.address = address;
    }

    public ClientId getclientId() {
        return clientId;
    }

    public Address getAddress() {
        return address;
    }
}
