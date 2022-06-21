package co.com.sofka.production.dispatch.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.dispatch.Dispatch;
import co.com.sofka.production.dispatch.commands.CreateClient;

public class CreateClientUseCase extends UseCase<RequestCommand<CreateClient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateClient> input) {
        var command = input.getCommand();
        var dispatch = Dispatch.from(command.getDispatchId(), repository().getEventsBy(command.getDispatchId().value()));

        dispatch.createClient(command.getClientId(), command.getName(), command.getAddress());
        emit().onResponse(new ResponseEvents(dispatch.getUncommittedChanges()));
    }
    
}
