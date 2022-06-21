package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.values.Type;

/**
 * Domain event for identify when a trated coffee process has started
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class TreatedCoffee extends DomainEvent {
    private final int coffeeToTreat;
    private final Type machineType;

    public TreatedCoffee(int coffeeToTreat, Type machineType) {
        super("production.dispatch.treatedcoffee");
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
