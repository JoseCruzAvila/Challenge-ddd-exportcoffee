package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Name;

/**
 * Class that acts like a command for update a client name
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateClientName extends Command {
    private final ClientId clientId;
    private final Name name;

    public UpdateClientName(ClientId clientId, Name name) {
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
