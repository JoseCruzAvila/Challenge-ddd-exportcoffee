package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Status;

/**
 * Domain event for identify when a coffeeBag status has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CoffeeBagStatusUpdated extends DomainEvent {
    private final CoffeeBagId coffeeBagId;
    private final Status status;

    public CoffeeBagStatusUpdated(CoffeeBagId entityId, Status status) {
        super("production.warehouse.coffeebagstatusupdated");
        this.coffeeBagId = entityId;
        this.status = status;
    }

    public CoffeeBagId getCoffeeBagId() {
        return coffeeBagId;
    }

    public Status getStatus() {
        return status;
    }
}
