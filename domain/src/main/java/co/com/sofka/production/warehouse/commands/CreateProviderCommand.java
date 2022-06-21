package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

/**
 * Class that acts like a command for create a provider
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class CreateProviderCommand extends Command {
    private final WarehouseId warehouseId;
    private final ProviderId providerId;
    private final Name name;
    private final Address address;

    public CreateProviderCommand(WarehouseId warehouseId, ProviderId providerId, Name name, Address address) {
        this.warehouseId = warehouseId;
        this.providerId = providerId;
        this.name = name;
        this.address = address;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
