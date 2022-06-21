package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.dispatch.values.Type;

/**
 * Domain event for identify when a machine is created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class AddedMachine extends DomainEvent {
    private final MachineId machineId;
    private final Type type;

    public AddedMachine(MachineId machineId, Type type) {
        super("production.dispatch.addedmachine");
        this.machineId = machineId;
        this.type = type;
    }

    public MachineId getMachineId() {
        return machineId;
    }

    public Type getType() {
        return type;
    }

}
