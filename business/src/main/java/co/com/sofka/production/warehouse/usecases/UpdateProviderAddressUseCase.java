package co.com.sofka.production.warehouse.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.warehouse.Warehouse;
import co.com.sofka.production.warehouse.commands.UpdateProviderAddress;

public class UpdateProviderAddressUseCase extends UseCase<RequestCommand<UpdateProviderAddress>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateProviderAddress> input) {
        var command = input.getCommand();
        var warehouse = Warehouse.from(command.getWarehouseId(), repository().getEventsBy(command.getWarehouseId().value()));

        warehouse.updateProviderAddress(command.getProviderId(), command.getAddress());
        emit().onResponse(new ResponseEvents(warehouse.getUncommittedChanges()));
    }
}
