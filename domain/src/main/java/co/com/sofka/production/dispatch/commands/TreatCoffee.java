package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.Type;

/**
 * Class that acts like a command for treat coffee
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class TreatCoffee extends Command {
    private final int coffeeToTreat;
    private final Type machineType;

    public TreatCoffee(int coffeeToTreat, Type machineType) {
        this.coffeeToTreat = coffeeToTreat;
        this.machineType = machineType;
    }

    public int getCoffeeToTreat() {
        return coffeeToTreat;
    }

    public Type getMachineType() {
        return machineType;
    }
}
