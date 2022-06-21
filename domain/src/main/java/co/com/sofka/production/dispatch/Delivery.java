package co.com.sofka.production.dispatch;

import java.util.Objects;
import java.util.Set;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.warehouse.CoffeeBag;

/**
 * class with the logic for manage the coffee delivery
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Delivery extends Entity<DeliveryId> {
    private ClientId clientId;
    private Description description;
    private Set<CoffeeBag> coffeeToDeliver;

    public Delivery(DeliveryId entityId, Description description) {
        super(entityId);
        this.description = description;
    }

    /**
     * Method for add a client to a delivery
     * 
     * @param clientId the client id to be asigned
     */
    public void addClient(ClientId clientId) {
        this.clientId = Objects.requireNonNull(clientId);
    }

    /**
     * Method for update the delivery description
     * 
     * @param description the new description
     */
    public void changeDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    /**
     * Method for add a coffee bag to be delivered
     * 
     * @param coffeeBag the ready coffe bag
     */
    public void addCoffeeToDeliver(CoffeeBag coffeeBag) {
        var coffee = Objects.requireNonNull(coffeeBag);
        this.coffeeToDeliver.add(coffee);
    }

    public ClientId clientId() {
        return clientId;
    }

    public Description description() {
        return description;
    }

    public Set<CoffeeBag> coffeeToDeliver() {
        return coffeeToDeliver;
    }
}
