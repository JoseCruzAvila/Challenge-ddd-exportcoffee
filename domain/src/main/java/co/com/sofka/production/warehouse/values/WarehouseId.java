package co.com.sofka.production.warehouse.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of a warehouse
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class WarehouseId extends Identity {
    public WarehouseId() {

    }

    private WarehouseId(String id) {
        super(id);
    }

    public static WarehouseId of(String id) {
        return new WarehouseId(id);
    }
}
