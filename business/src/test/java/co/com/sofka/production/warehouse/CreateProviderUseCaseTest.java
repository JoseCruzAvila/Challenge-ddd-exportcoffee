package co.com.sofka.production.warehouse;

import java.util.List;
import java.util.Map;

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
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.commands.CreateProviderCommand;
import co.com.sofka.production.warehouse.events.CreatedProvider;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.usecases.CreateProviderUseCase;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateProviderUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    CreateProviderUseCase useCase;
    
    @Test
    void createProvider() {
        //arrange
        var warehouseId = new WarehouseId();
        Name name = new Name("Federación nacional de cafeteros");
        Address address = new Address("Colombia", "Manizales", "Cra 2");

        var command = new CreateProviderCommand(warehouseId, new ProviderId(), name, address);

        when(repository.getEventsBy(warehouseId.value())).thenReturn(history(warehouseId));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedProvider) events.get(0);
        Assertions.assertEquals("Federación nacional de cafeteros", event.getName().value());
        Assertions.assertEquals(Map.of("Country", "Colombia", "City", "Manizales", "Address", "Cra 2"), event.getAddress().value());
    } 

    private List<DomainEvent> history(WarehouseId warehouseId) {
        return List.of(
                new CreatedWarehouse(warehouseId, new Capacity(50))
                );
    }
}
