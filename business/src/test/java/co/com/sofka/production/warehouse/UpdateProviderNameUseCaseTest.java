package co.com.sofka.production.warehouse;

import java.util.List;

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
import co.com.sofka.production.warehouse.commands.UpdateProviderName;
import co.com.sofka.production.warehouse.events.CreatedProvider;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.events.ProviderNameUpdated;
import co.com.sofka.production.warehouse.usecases.UpdateProviderNameUseCase;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateProviderNameUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    UpdateProviderNameUseCase useCase;
    
    @Test
    void updateProviderName() {
        //arrange
        var warehouseId = new WarehouseId();
        var providerId = new ProviderId();
        var name = new Name("La Meseta");

        var command = new UpdateProviderName(warehouseId, providerId, name);

        when(repository.getEventsBy(warehouseId.value())).thenReturn(history(warehouseId, providerId));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProviderNameUpdated) events.get(0);
        Assertions.assertEquals("La Meseta", event.getName().value());
    } 

    private List<DomainEvent> history(WarehouseId warehouseId, ProviderId providerId) {
        Name name = new Name("Federación nacional de cafeteros");
        Address address = new Address("Colombia", "Manizales", "Cra 2");

        return List.of(
                new CreatedWarehouse(warehouseId, new Capacity(50)),
                new CreatedProvider(providerId, name, address)
                );
    }
}
