package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.DeliveryId;

/**
 * Domain event for identify when an coffee bag has been added to a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CoffeeBagAddedToDelivery extends DomainEvent {
    private final DeliveryId deliveryId;

    public CoffeeBagAddedToDelivery(DeliveryId deliveryId) {
        super("production.dispatch.coffeebagaddedtodelivery");
        this.deliveryId = deliveryId;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }
}
