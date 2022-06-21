package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Domain event for identify when a provider is created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedProvider extends DomainEvent {
    private final ProviderId providerId;
    private final Name name;
    private final Address address;

    public CreatedProvider(ProviderId providerId, Name name, Address address) {
        super("production.warehouse.createdprovider");
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
