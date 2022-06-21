package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.WarehouseId;

/**
 * Domain event for identify when a warehouse has been created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedWarehouse extends DomainEvent {
    private final WarehouseId warehouseId;
    private final Capacity capacity;

    public CreatedWarehouse(WarehouseId entityId, Capacity capacity) {
        super("production.warehouse.createdwarehouse");
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
