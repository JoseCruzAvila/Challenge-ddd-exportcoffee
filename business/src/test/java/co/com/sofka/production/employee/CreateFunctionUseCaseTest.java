package co.com.sofka.production.employee;

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
import co.com.sofka.production.employee.commands.CreateFunctionCommand;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.events.CreatedFunction;
import co.com.sofka.production.employee.usecases.CreateFunctionUseCase;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

import static org.mockito.Mockito.when;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CreateFunctionUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    CreateFunctionUseCase useCase;
    
    @Test
    void createFunction(){
        EmployeeId id = new EmployeeId();
        var name = new Name("Toast Coffee");
        var description = new Description("Toast Coffee in a machine");
        var command = new CreateFunctionCommand(id, new FunctionId(), name, description);

        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedFunction) events.get(0);
        Assertions.assertEquals("Toast Coffee", event.getName().value());
        Assertions.assertEquals("Toast Coffee in a machine", event.getDescription().value());
    } 

    private List<DomainEvent> history() {
        Fullname fullname = new Fullname("Jose Daniel", "Cruz Ávila");
        Address address = new Address("Colombia", "Manizales", "Cra 2");
        return List.of(
                new CreatedEmployee(fullname, address, new StartDate())
                );
    }
}
