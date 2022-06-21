package co.com.sofka.production.dispatch.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class DeliveryId extends Identity {
    public DeliveryId() {

    }

    private DeliveryId(String id) {
        super(id);
    }

    public static DeliveryId of(String id) {
        return new DeliveryId(id);
    }
}
