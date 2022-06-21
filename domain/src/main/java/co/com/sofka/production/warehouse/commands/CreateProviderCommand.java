package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Class that acts like a command for create a provider
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateProviderCommand extends Command {
    private final ProviderId providerId;
    private final Name name;
    private final Address address;

    public CreateProviderCommand(ProviderId providerId, Name name, Address address) {
        this.providerId = providerId;
        this.name = name;
        this.address = address;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
