package co.com.sofka.production.warehouse.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.warehouse.Warehouse;
import co.com.sofka.production.warehouse.commands.UpdateProviderName;

public class UpdateProviderNameUseCase extends UseCase<RequestCommand<UpdateProviderName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateProviderName> input) {
        var command = input.getCommand();
        var warehouse = Warehouse.from(command.getWarehouseId(), repository().getEventsBy(command.getWarehouseId().value()));

        warehouse.updateProviderName(command.getProviderId(), command.getName());
        emit().onResponse(new ResponseEvents(warehouse.getUncommittedChanges()));
    }
}
