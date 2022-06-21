package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Price;

/**
 * Domain event for identify when a coffeeBag price has been updated
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CoffeeBagPriceUpdated extends DomainEvent {
    private final CoffeeBagId coffeeBagId;
    private final Price price;

    public CoffeeBagPriceUpdated(CoffeeBagId entityId, Price price) {
        super("production.warehouse.coffeebagstatusupdated");
        this.coffeeBagId = entityId;
        this.price = price;
    }

    public CoffeeBagId getCoffeeBagId() {
        return coffeeBagId;
    }

    public Price getPrice() {
        return price;
    }
}
