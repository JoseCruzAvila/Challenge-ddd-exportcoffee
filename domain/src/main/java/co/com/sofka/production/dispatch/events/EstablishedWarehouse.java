package co.com.sofka.production.dispatch.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.Warehouse;

/**
 * Domain event for identify when a warehouse is asigned to a dispatch
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EstablishedWarehouse extends DomainEvent {
    private final Warehouse warehouse;

    public EstablishedWarehouse(Warehouse warehouse) {
        super("production.dispatch.establishedwarehouse");
        this.warehouse = warehouse;
    }

    public Warehouse warehouse() {
        return warehouse;
    }
}
