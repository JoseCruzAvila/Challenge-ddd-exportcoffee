package co.com.sofka.production.warehouse;

import java.util.HashSet;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.production.warehouse.events.CoffeeBagPriceUpdated;
import co.com.sofka.production.warehouse.events.CoffeeBagStatusUpdated;
import co.com.sofka.production.warehouse.events.CreatedCoffeeBag;
import co.com.sofka.production.warehouse.events.CreatedProvider;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.events.ProviderAddressUpdated;
import co.com.sofka.production.warehouse.events.ProviderNameUpdated;
import co.com.sofka.production.warehouse.events.UpdatedBagAmmountToBuy;
import co.com.sofka.production.warehouse.values.Status;

public class WarehouseChange extends EventChange {
    public WarehouseChange(Warehouse warehouse) {
        apply((CreatedWarehouse event) -> {
            warehouse.capacity = event.getCapacity();
            warehouse.providers = new HashSet<>();
            warehouse.coffeeBags = new HashSet<>();
        });

        apply((CreatedCoffeeBag event) -> {
            warehouse.coffeeBags.add(new CoffeeBag(event.getCoffeeBagId(), new Status(Status.Current.NOTREAT), event.getWeight(), event.getPrice()));
        });

        apply((CreatedProvider event) -> {
            warehouse.providers.add(new Provider(event.getProviderId(), event.getName(), event.getAddress()));
        });

        apply((CoffeeBagStatusUpdated event) -> {
            var coffeBag = warehouse.getCoffeeBagById(event.getCoffeeBagId())
                                    .orElseThrow(() -> new IllegalArgumentException("The given coffebag id doesn't exist"));
            
            coffeBag.changeStatus(event.getStatus());
        });

        apply((CoffeeBagPriceUpdated event) -> {
            var coffeBag = warehouse.getCoffeeBagById(event.getCoffeeBagId())
                                    .orElseThrow(() -> new IllegalArgumentException("The given coffebag id doesn't exist"));
            
            coffeBag.changePrice(event.getPrice());
        });

        apply((UpdatedBagAmmountToBuy event) -> {
            var provider = warehouse.getProviderById(event.getProviderId())
                                    .orElseThrow(() -> new IllegalArgumentException("The given provider id doesn't exist"));
            
            provider.changeBagAmmount(event.getBagAmmount());
        });

        apply((ProviderNameUpdated event) -> {
            var provider = warehouse.getProviderById(event.getProviderId())
                                    .orElseThrow(() -> new IllegalArgumentException("The given provider id doesn't exist"));
            
            provider.changeName(event.getName());
        });

        apply((ProviderAddressUpdated event) -> {
            var provider = warehouse.getProviderById(event.getProviderId())
                                    .orElseThrow(() -> new IllegalArgumentException("The given provider id doesn't exist"));
            
            provider.changeAddress(event.getAddress());
        });
    }
}
