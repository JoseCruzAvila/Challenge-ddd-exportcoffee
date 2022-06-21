package co.com.sofka.production.employee;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.production.employee.commands.CreateEmployeeCommand;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.usecases.CreateEmployeeUseCase;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.general.values.Address;

public class CreateEmployeeUseCaseTest {
    
    @Test
    void createEmployee(){
        //arrange
        Fullname fullname = new Fullname("Jose Daniel", "Cruz Ávila");
        Address address = new Address("Colombia", "Manizales", "Cra 2");
        var command = new CreateEmployeeCommand(new EmployeeId(), fullname, address);
        var usecase = new CreateEmployeeUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedEmployee)events.get(0);
        Assertions.assertEquals("Jose Daniel Cruz Ávila", event.getFullname().value());
        Assertions.assertEquals(Map.of("Country", "Colombia", "City", "Manizales", "Address", "Cra 2"), event.getAddress().value());
    } 
}
