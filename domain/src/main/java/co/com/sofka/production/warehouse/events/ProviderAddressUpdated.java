package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Domain event for identify when a provider address is updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ProviderAddressUpdated extends DomainEvent {
    private final ProviderId providerId;
    private final Address address;

    public ProviderAddressUpdated(ProviderId clientId, Address address) {
        super("production.warehouse.provideraddressupdated");
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
