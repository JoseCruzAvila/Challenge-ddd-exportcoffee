package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.dispatch.values.Type;

/**
 * Class that acts like a command for create a machine
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateMachine extends Command {
    private final MachineId machineId;
    private final Type type;

    public CreateMachine(MachineId machineId, Type type) {
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
