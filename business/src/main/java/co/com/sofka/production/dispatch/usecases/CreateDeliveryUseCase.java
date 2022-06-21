package co.com.sofka.production.dispatch.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.dispatch.Dispatch;
import co.com.sofka.production.dispatch.commands.CreateDelivery;

public class CreateDeliveryUseCase extends UseCase<RequestCommand<CreateDelivery>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateDelivery> input) {
        var command = input.getCommand();
        var dispatch = Dispatch.from(command.getDispatchId(), repository().getEventsBy(command.getDispatchId().value()));

        dispatch.addDelivery(command.getDeliveryId(), command.getDescription(), command.getClientId());
        emit().onResponse(new ResponseEvents(dispatch.getUncommittedChanges()));
    }
    
}
