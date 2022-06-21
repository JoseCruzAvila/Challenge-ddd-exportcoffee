package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.general.values.Description;

/**
 * Class that acts like a command for create a delivery
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class CreateDelivery extends Command {
    private final DispatchId dispatchId;
    private final DeliveryId deliveryId;
    private final Description description;
    private final ClientId clientId;

    public CreateDelivery(DispatchId dispatchId, DeliveryId deliveryId, Description description, ClientId clientId) {
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
