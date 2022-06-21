package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.general.values.Description;

/**
 * Domain event for identify when a delivery is created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class AddedDelivery extends DomainEvent {
    private final DeliveryId deliveryId;
    private final Description description;

    public AddedDelivery(DeliveryId deliveryId, Description description) {
        super("production.dispatch.addeddelivery");
        this.deliveryId = deliveryId;
        this.description = description;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }

    public Description getDescription() {
        return description;
    }
}
