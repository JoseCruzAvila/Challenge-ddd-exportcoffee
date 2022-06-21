package co.com.sofka.production.dispatch.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a dispatch
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class DispatchId extends Identity {
    public DispatchId() {

    }

    private DispatchId(String id) {
        super(id);
    }

    public static DispatchId of(String id) {
        return new DispatchId(id);
    }
}
