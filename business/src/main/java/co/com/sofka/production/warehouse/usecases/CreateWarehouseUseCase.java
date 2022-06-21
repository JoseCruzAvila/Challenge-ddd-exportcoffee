package co.com.sofka.production.warehouse.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.warehouse.Warehouse;
import co.com.sofka.production.warehouse.commands.CreateWarehouseCommand;

public class CreateWarehouseUseCase extends UseCase<RequestCommand<CreateWarehouseCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateWarehouseCommand> input) {
        var command = input.getCommand();
        var warehouse = new Warehouse(command.getWarehouseId(), command.getCapacity());

        emit().onResponse(new ResponseEvents(warehouse.getUncommittedChanges()));
    }
}
