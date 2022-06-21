package co.com.sofka.production.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.production.warehouse.commands.CreateWarehouseCommand;
import co.com.sofka.production.warehouse.events.CreatedWarehouse;
import co.com.sofka.production.warehouse.usecases.CreateWarehouseUseCase;
import co.com.sofka.production.warehouse.values.Capacity;
import co.com.sofka.production.warehouse.values.WarehouseId;

public class CreateWarehouseUseCaseTest {
    @Test
    void createWarehouse(){
        //arrange
        var capacity = new Capacity(50);
        var command = new CreateWarehouseCommand(new WarehouseId(), capacity);
        var usecase = new CreateWarehouseUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedWarehouse)events.get(0);
        Assertions.assertEquals(50, event.getCapacity().value());
    } 
}
