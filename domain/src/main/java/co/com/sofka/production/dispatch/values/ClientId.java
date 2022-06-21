package co.com.sofka.production.dispatch.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a client
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ClientId extends Identity {
    public ClientId() {

    }

    private ClientId(String id) {
        super(id);
    }

    public static ClientId of(String id) {
        return new ClientId(id);
    }
}
