package co.com.sofka.production.dispatch.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.production.dispatch.Dispatch;
import co.com.sofka.production.dispatch.events.AddedDelivery;

public class AddClientToDeliveryUseCase extends UseCase<TriggeredEvent<AddedDelivery>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<AddedDelivery> input) {
        var event = input.getDomainEvent();
        var dispatch = Dispatch.from(event.getDispatchId(), repository().getEventsBy(event.getDispatchId().value()));

        dispatch.addClientToDeliver(event.getClientId(), event.getDeliveryId());
        emit().onResponse(new ResponseEvents(dispatch.getUncommittedChanges()));
    }
}
