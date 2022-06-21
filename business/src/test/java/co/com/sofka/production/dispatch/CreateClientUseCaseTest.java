package co.com.sofka.production.dispatch;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.commands.CreateClient;
import co.com.sofka.production.dispatch.events.CreatedClient;
import co.com.sofka.production.dispatch.events.CreatedDispatch;
import co.com.sofka.production.dispatch.usecases.CreateClientUseCase;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.dispatch.values.Schedule;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateClientUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    CreateClientUseCase useCase;
    
    @Test
    void createClient() {
        //arrange
        var dispatchId = new DispatchId();
        Name name = new Name("Starbucks");
        Address address = new Address("Colombia", "Manizales", "Cra 2");
        var command = new CreateClient(dispatchId, new ClientId(), name, address);

        when(repository.getEventsBy(dispatchId.value())).thenReturn(history(dispatchId));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedClient) events.get(0);
        Assertions.assertEquals("Starbucks", event.getName().value());
        Assertions.assertEquals(Map.of("Country", "Colombia", "City", "Manizales", "Address", "Cra 2"), event.getAddress().value());
    } 

    private List<DomainEvent> history(DispatchId dispatchId) {
        var days = Set.of(
            Schedule.Days.MO,
            Schedule.Days.TU,
            Schedule.Days.WE,
            Schedule.Days.TH,
            Schedule.Days.FR
        );
        Schedule schedule = new Schedule(days, LocalTime.of(8, 0), LocalTime.of(16, 0));

        return List.of(
                new CreatedDispatch(dispatchId, schedule)
                );
    }
}
