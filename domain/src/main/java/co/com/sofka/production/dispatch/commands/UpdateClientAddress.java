package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Address;

/**
 * Class that acts like a command for update a client address
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateClientAddress extends Command {
    private final ClientId clientId;
    private final Address address;

    public UpdateClientAddress(ClientId clientId, Address address) {
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
