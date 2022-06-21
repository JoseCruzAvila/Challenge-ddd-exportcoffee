package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.WarehouseId;

/**
 * Class that acts like a command for create a warehouse
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreateWarehouseCommand extends Command {
    private final WarehouseId warehouseId;
    private final Capacity capacity;

    public CreateWarehouseCommand(WarehouseId entityId, Capacity capacity) {
        this.warehouseId = entityId;
        this.capacity = capacity;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
