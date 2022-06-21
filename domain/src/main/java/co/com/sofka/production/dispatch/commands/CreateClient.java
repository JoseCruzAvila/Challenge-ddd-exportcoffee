package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for create a client
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateClient extends Command {
    private final ClientId clientId;
    private final Name name;
    private final Address address;

    public CreateClient(ClientId clientId, Name name, Address address) {
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
