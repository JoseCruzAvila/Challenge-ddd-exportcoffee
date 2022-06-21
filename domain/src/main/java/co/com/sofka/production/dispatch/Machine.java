package co.com.sofka.production.dispatch;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.dispatch.values.Maintenance;
import co.com.sofka.production.dispatch.values.TreatCoffeeCount;
import co.com.sofka.production.dispatch.values.Type;

/**
 * class that acts like a machine owned by a dispatch in the company
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Machine extends Entity<MachineId> {
    private Type type;
    private Maintenance maintenance;
    private TreatCoffeeCount treatedCoffee;

    public Machine(MachineId entityId, Type type) {
        super(entityId);
        this.type = type;
    }

    /**
     * Method that program a new maintenance for the machine
     * 
     * @param maintenance the new maintenance
     */
    public void addMaintenance(Maintenance maintenance) {
        this.maintenance = Objects.requireNonNull(maintenance);
    }

    /**
     * Method that update the quantity of coffee tretad for the machine
     * 
     * @param treatedCoffee the new quantity
     */
    public void makeCoffeeTreatment(TreatCoffeeCount treatedCoffee) {
        this.treatedCoffee = Objects.requireNonNull(treatedCoffee);
    }

    public Type type() {
        return type;
    }

    public Maintenance maintenance() {
        return maintenance;
    }

    public TreatCoffeeCount treatedCoffee() {
        return treatedCoffee;
    }
}
