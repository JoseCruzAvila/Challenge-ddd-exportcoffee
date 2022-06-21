package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.values.BagAmmount;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Domain event for identify when a provider ammount to boy is upcated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdatedBagAmmountToBuy extends DomainEvent {
    private final ProviderId providerId;
    private final BagAmmount bagAmmount;

    public UpdatedBagAmmountToBuy(ProviderId clientId, BagAmmount bagAmmount) {
        super("production.warehouse.updatedbagammounttobuy");
        this.providerId = clientId;
        this.bagAmmount = bagAmmount;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public BagAmmount getBagAmmount() {
        return bagAmmount;
    }
}
