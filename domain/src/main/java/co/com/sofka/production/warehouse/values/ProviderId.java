package co.com.sofka.production.warehouse.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a provider
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ProviderId extends Identity {
    public ProviderId() {

    }

    private ProviderId(String id) {
        super(id);
    }

    public static ProviderId of(String id) {
        return new ProviderId(id);
    }
}
