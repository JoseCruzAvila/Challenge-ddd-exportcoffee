package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;

/**
 * Domain event for identify when a client is added to a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ClientAddedToDelivery extends DomainEvent {
    private final ClientId clientId;
    private final DeliveryId deliveryId;

    public ClientAddedToDelivery(ClientId clientId, DeliveryId deliveryId) {
        super("production.dispatch.clientaddedtodelivery");
        this.clientId = clientId;
        this.deliveryId = deliveryId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }
}
