package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.warehouse.values.CoffeeBagId;
import co.com.sofka.production.warehouse.values.Price;

/**
 * Class that acts like a command for upcate a coffeebag price
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateCoffeeBagPrice extends Command {
    private final CoffeeBagId coffeeBagId;
    private final Price price;

    public UpdateCoffeeBagPrice(CoffeeBagId entityId, Price price) {
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
