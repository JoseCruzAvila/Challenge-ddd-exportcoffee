package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.DeliveryId;

/**
 * Class that acts like a command for add a coffeebag to a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class AddCoffeeBagToDelivery extends Command {
    private final DeliveryId deliveryId;

    public AddCoffeeBagToDelivery(DeliveryId deliveryId) {
        this.deliveryId = deliveryId;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }
}
