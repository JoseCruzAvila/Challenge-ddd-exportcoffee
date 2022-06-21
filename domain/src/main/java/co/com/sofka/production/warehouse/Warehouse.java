package co.com.sofka.production.warehouse;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.events.CoffeeBagPriceUpdated;
import co.com.sofka.production.warehouse.events.CoffeeBagStatusUpdated;
import co.com.sofka.production.warehouse.events.CreatedCoffeeBag;
import co.com.sofka.production.warehouse.events.CreatedProvider;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.events.ProviderAddressUpdated;
import co.com.sofka.production.warehouse.events.ProviderNameUpdated;
import co.com.sofka.production.warehouse.events.UpdatedBagAmmountToBuy;
import co.com.sofka.production.warehouse.values.BagAmmount;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Price;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.Status;
import co.com.sofka.production.warehouse.values.WarehouseId;
import co.com.sofka.production.warehouse.values.Weight;

/**
 * Class with the logic for manage all the warehouse info
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Warehouse extends AggregateEvent<WarehouseId> {
    protected Capacity capacity;
    protected Set<CoffeeBag> coffeeBags;
    protected Set<Provider> providers;

    public Warehouse(WarehouseId entityId, Capacity capacity) {
        super(entityId);
        appendChange(new CreatedWarehouse(entityId, capacity)).apply();
    }

    private Warehouse(WarehouseId entityId) {
        super(entityId);
        subscribe(new WarehouseChange(this));
    }

    public static Warehouse from(WarehouseId entityId, List<DomainEvent> events) {
        var warehouse = new Warehouse(entityId);
        events.forEach(warehouse::applyEvent);
        
        return warehouse;
    }

    /**
     * Method for create a CoffeeBag
     * 
     * @param entityId the coffee bag id
     * @param weight the weight of the coffee bag
     * @param price the price of the coffe bag
     */
    public void addCoffeeBags(CoffeeBagId entityId, Weight weight, Price price) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(weight);
        Objects.requireNonNull(price);

        appendChange(new CreatedCoffeeBag(entityId, weight, price)).apply();
    }

    /**
     * Method for create a provider
     * 
     * @param entityId provider id
     * @param name the provider name
     * @param address the provider address
     */
    public void addProviders(ProviderId entityId, Name name, Address address) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);

        appendChange(new CreatedProvider(entityId, name, address)).apply();
    }

    /**
     * Method for update the coffee bag status
     * 
     * @param entityId the coffe bag id
     * @param status the new status of the coffee bag
     */
    public void updateCoffeeBagStatus(CoffeeBagId entityId, Status status) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(status);

        appendChange(new CoffeeBagStatusUpdated(entityId, status)).apply();
    }

    /**
     * Method for update the coffee bag price
     * 
     * @param entityId the coffe bag id
     * @param price the coffe bag price
     */
    public void updateCoffeeBagPrice(CoffeeBagId entityId, Price price) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(price);

        appendChange(new CoffeeBagPriceUpdated(entityId, price)).apply();
    }

    /**
     * Method for update the ammount to buy to the provider of coffee bags
     * 
     * @param entityId the provider id
     * @param bagAmmount the new quantity to buy
     */
    public void updateBagAmmountToBuy(ProviderId entityId, BagAmmount bagAmmount) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(bagAmmount);

        appendChange(new UpdatedBagAmmountToBuy(entityId, bagAmmount)).apply();
    }

    /**
     * Method for update the provider name
     * 
     * @param entityId the provider id
     * @param name the new provider name
     */
    public void updateProviderName(ProviderId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);

        appendChange(new ProviderNameUpdated(entityId, name)).apply();
    }

    /**
     * Method for update the provider address
     * 
     * @param entityId the provider id
     * @param address the new provider address
     */
    public void updateProviderAddress(ProviderId entityId, Address address) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(address);

        appendChange(new ProviderAddressUpdated(entityId, address)).apply();
    }

    /**
     * Function that allows to get a CoffeeBag by its id
     * 
     * @param entityId the CoffeeBag id
     * @return the CoffeeBag if it exists
     */
    public Optional<CoffeeBag> getCoffeeBagById(CoffeeBagId entityId) {
        return coffeeBags().stream()
                           .filter(bag -> bag.identity().equals(entityId))
                           .findFirst();
    }

     /**
     * Function that allows to get a provider by its id
     * 
     * @param entityId the provider id
     * @return the provider if it exists
     */
    public Optional<Provider> getProviderById(ProviderId entityId) {
        return providers().stream()
                           .filter(provider -> provider.identity().equals(entityId))
                           .findFirst();
    }

    public Capacity capacity() {
        return capacity;
    }

    public Set<CoffeeBag> coffeeBags() {
        return coffeeBags;
    }

    public Set<Provider> providers() {
        return providers;
    }
}
