package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.general.values.Description;

/**
 * Class that acts like a command for create a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateDelivery extends Command {
    private final DeliveryId deliveryId;
    private final Description description;

    public CreateDelivery(DeliveryId deliveryId, Description description) {
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
