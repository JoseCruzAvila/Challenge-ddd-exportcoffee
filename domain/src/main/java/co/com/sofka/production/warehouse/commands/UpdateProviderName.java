package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

/**
 * Class that acts like a command for update a provider name
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateProviderName extends Command {
    private final WarehouseId warehouseId;
    private final ProviderId providerId;
    private final Name name;

    public UpdateProviderName(WarehouseId warehouseId, ProviderId providerId, Name name) {
        this.warehouseId = warehouseId;
        this.providerId = providerId;
        this.name = name;
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
}
