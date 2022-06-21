package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when a client is created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedClient extends DomainEvent {
    private final ClientId clientId;
    private final Name name;
    private final Address address;

    public CreatedClient(ClientId clientId, Name name, Address address) {
        super("production.dispatch.createdclient");
        this.clientId = clientId;
        this.name = name;
        this.address = address;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
