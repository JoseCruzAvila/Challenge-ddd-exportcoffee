package co.com.sofka.production.dispatch.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class MachineId extends Identity {
    public MachineId() {

    }

    private MachineId(String id) {
        super(id);
    }

    public static MachineId of(String id) {
        return new MachineId(id);
    }
}
