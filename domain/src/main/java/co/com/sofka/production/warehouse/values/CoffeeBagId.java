package co.com.sofka.production.warehouse.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a coffe bag
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class CoffeeBagId extends Identity {
    public CoffeeBagId() {

    }

    private CoffeeBagId(String id) {
        super(id);
    }

    public static CoffeeBagId of(String id) {
        return new CoffeeBagId(id);
    }
}
