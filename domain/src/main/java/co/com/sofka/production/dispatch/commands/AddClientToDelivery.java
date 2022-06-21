package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;

/**
 * Class that acts like a command for add a client to a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class AddClientToDelivery extends Command {
    private final ClientId clientId;
    private final DeliveryId deliveryId;

    public AddClientToDelivery(ClientId clientId, DeliveryId deliveryId) {
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
