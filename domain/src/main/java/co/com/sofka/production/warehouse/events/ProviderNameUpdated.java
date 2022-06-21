package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Domain event for identify when a provider name is updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ProviderNameUpdated extends DomainEvent {
    private final ProviderId providerId;
    private final Name name;

    public ProviderNameUpdated(ProviderId providerId, Name name) {
        super("production.warehouse.providernameupdated");
        this.providerId = providerId;
        this.name = name;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName() {
        return name;
    }
}
