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
import co.com.sofka.production.warehouse.commands.UpdateProviderAddress;
import co.com.sofka.production.warehouse.events.CreatedProvider;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.events.ProviderAddressUpdated;
import co.com.sofka.production.warehouse.usecases.UpdateProviderAddressUseCase;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.ProviderId;
import co.com.sofka.production.warehouse.values.WarehouseId;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateProviderAddressUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    UpdateProviderAddressUseCase useCase;
    
    @Test
    void updateProviderAddress() {
        //arrange
        var warehouseId = new WarehouseId();
        var providerId = new ProviderId();
        var address = new Address("Colombia", "Bogotá", "Avenida Américas");

        var command = new UpdateProviderAddress(warehouseId, providerId, address);

        when(repository.getEventsBy(warehouseId.value())).thenReturn(history(warehouseId, providerId));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProviderAddressUpdated) events.get(0);
        Assertions.assertEquals(Map.of("Country", "Colombia", "City", "Bogotá", "Address", "Avenida Américas"), event.getAddress().value());
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
