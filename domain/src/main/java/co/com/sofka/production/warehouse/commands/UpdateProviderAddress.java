package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

/**
 * Class that acts like a command for update a provider address
 * 
 * @author Jose Cruz
 * @version 3.0
 */
public class UpdateProviderAddress extends Command {
    public final WarehouseId warehouseId;
    private final ProviderId providerId;
    private final Address address;

    public UpdateProviderAddress(WarehouseId warehouseId, ProviderId providerId, Address address) {
        this.warehouseId = warehouseId;
        this.providerId = providerId;
        this.address = address;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Address getAddress() {
        return address;
    }
}
