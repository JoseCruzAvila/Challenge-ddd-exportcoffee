package co.com.sofka.production.warehouse.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.warehouse.Warehouse;
import co.com.sofka.production.warehouse.commands.CreateProviderCommand;

public class CreateProviderUseCase extends UseCase<RequestCommand<CreateProviderCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateProviderCommand> input) {
        var command = input.getCommand();
        var warehouse = Warehouse.from(command.getWarehouseId(), repository().getEventsBy(command.getWarehouseId().value()));

        warehouse.addProviders(command.getProviderId(), command.getName(), command.getAddress());
        emit().onResponse(new ResponseEvents(warehouse.getUncommittedChanges()));
    }
}
