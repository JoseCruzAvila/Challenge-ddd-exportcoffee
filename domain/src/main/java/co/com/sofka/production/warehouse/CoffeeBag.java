package co.com.sofka.production.warehouse;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Price;
import co.com.sofka.production.warehouse.values.Status;
import co.com.sofka.production.warehouse.values.Weight;


/**
 * class with thw logic for manage the bag coffee info
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CoffeeBag extends Entity<CoffeeBagId> {
    private Status status;
    private Weight weight;
    private Price price;

    public CoffeeBag(CoffeeBagId entityId, Status status, Weight weight, Price price) {
        super(entityId);
        this.status = status;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Method for change the coffee bag status
     * 
     * @param status the new status
     */
    protected void changeStatus(Status status) {
        this.status = Objects.requireNonNull(status);
    }

    /**
     * Method for change the coffee bag price
     * @param price the new price
     */
    protected void changePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public Status status() {
        return status;
    }

    public Weight weight() {
        return weight;
    }

    public Price price() {
        return price;
    }
}
