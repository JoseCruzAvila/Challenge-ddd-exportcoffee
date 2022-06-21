package co.com.sofka.production.dispatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.events.AddedDelivery;
import co.com.sofka.production.dispatch.events.ClientAddedToDelivery;
import co.com.sofka.production.dispatch.events.CreatedClient;
import co.com.sofka.production.dispatch.events.CreatedDispatch;
import co.com.sofka.production.dispatch.usecases.AddClientToDeliveryUseCase;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.dispatch.values.Schedule;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class AddClientToDeliveryUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    AddClientToDeliveryUseCase useCase;
    
    @Test
    void AddClientToDeliveryUseCase(){
        //arrange
        DispatchId dispatchId = new DispatchId();
        DeliveryId deliveryId = new DeliveryId();
        ClientId clientId = new ClientId();

        when(repository.getEventsBy(dispatchId.value())).thenReturn(history(dispatchId, deliveryId));
        useCase.addRepository(repository);

        var description = new Description("Deliver to Juan Veldéz");

        var event = new AddedDelivery(dispatchId, deliveryId, description, clientId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventAnswer = (ClientAddedToDelivery) events.get(0);
        Assertions.assertEquals(clientId.value(), eventAnswer.getClientId().value());
        Assertions.assertEquals("Deliver to Juan Veldéz", event.getDescription().value());
    } 

    private List<DomainEvent> history(DispatchId dispatchId, DeliveryId deliveryId) {
        var clientId = new ClientId();

        var days = Set.of(
            Schedule.Days.MO,
            Schedule.Days.TU,
            Schedule.Days.WE,
            Schedule.Days.TH,
            Schedule.Days.FR
        );
        Schedule schedule = new Schedule(days, LocalTime.of(8, 0), LocalTime.of(16, 0));

        Name name = new Name("Juan Valdez");
        Address address = new Address("Colombia", "Manizales", "Cra 2");

        var description = new Description("Deliver to Juan Veldéz");

        return List.of(
                new CreatedDispatch(dispatchId, schedule),
                new CreatedClient(clientId, name, address),
                new AddedDelivery(dispatchId, deliveryId, description, clientId)
                );
    }
}
