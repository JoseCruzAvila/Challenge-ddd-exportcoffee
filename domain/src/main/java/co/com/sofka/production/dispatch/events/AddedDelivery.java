package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.general.values.Description;

/**
 * Domain event for identify when a delivery is created
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class AddedDelivery extends DomainEvent {
    private final DispatchId dispatchId;
    private final DeliveryId deliveryId;
    private final Description description;
    private final ClientId clientId;

    public AddedDelivery(DispatchId dispatchId, DeliveryId deliveryId, Description description, ClientId clientId) {
        super("production.dispatch.addeddelivery");
        this.dispatchId = dispatchId;
        this.deliveryId = deliveryId;
        this.description = description;
        this.clientId = clientId;
    }

    public DispatchId getDispatchId() {
        return dispatchId;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }

    public Description getDescription() {
        return description;
    }

    public ClientId getClientId() {
        return clientId;
    }
}
