package co.com.sofka.production.warehouse.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Price;
import co.com.sofka.production.warehouse.values.Weight;

/**
 * Domain event for identify when a coffeeBag has been created
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CreatedCoffeeBag extends DomainEvent {
    private final CoffeeBagId coffeeBagId;
    private final Weight weight;
    private final Price price;

    public CreatedCoffeeBag(CoffeeBagId entityId, Weight weight, Price price) {
        super("production.warehouse.createdcoffeebag");
        this.coffeeBagId = entityId;
        this.weight = weight;
        this.price = price;
    }

    public CoffeeBagId getCoffeeBagId() {
        return coffeeBagId;
    }

    public Weight getWeight() {
        return weight;
    }

    public Price getPrice() {
        return price;
    }
}
