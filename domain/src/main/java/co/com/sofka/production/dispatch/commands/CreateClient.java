package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for create a client
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class CreateClient extends Command {
    private final DispatchId dispatchId;
    private final ClientId clientId;
    private final Name name;
    private final Address address;

    public CreateClient(DispatchId dispatchId, ClientId clientId, Name name, Address address) {
        this.dispatchId = dispatchId;
        this.clientId = clientId;
        this.name = name;
        this.address = address;
    }

    public DispatchId getDispatchId() {
        return dispatchId;
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
