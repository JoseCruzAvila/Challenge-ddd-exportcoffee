package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Class that acts like a command for update a provider address
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateProviderAddress extends Command {
    private final ProviderId providerId;
    private final Address address;

    public UpdateProviderAddress(ProviderId clientId, Address address) {
        this.providerId = clientId;
        this.address = address;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Address getAddress() {
        return address;
    }
}
