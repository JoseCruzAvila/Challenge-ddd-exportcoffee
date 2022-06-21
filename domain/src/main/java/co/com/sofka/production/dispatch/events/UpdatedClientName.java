package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Name;

/**
 * Domain event for identify when a client name is updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedClientName extends DomainEvent {
    private final ClientId clientId;
    private final Name name;

    public UpdatedClientName(ClientId clientId, Name name) {
        super("production.dispatch.updatedclientname");
        this.clientId = clientId;
        this.name = name;
    }

    public ClientId getclientId() {
        return clientId;
    }

    public Name getName() {
        return name;
    }
}
