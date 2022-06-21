package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.warehouse.Warehouse;

/**
 * Class that acts like a command for add a wirehouse to a dispatch
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EstablishWarehouse extends Command {
    private final Warehouse warehouse;

    public EstablishWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse warehouse() {
        return warehouse;
    }
}
