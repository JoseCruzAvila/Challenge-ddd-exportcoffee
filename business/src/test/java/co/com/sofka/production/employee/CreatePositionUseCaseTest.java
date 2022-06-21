package co.com.sofka.production.employee;

import java.util.List;

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
import co.com.sofka.production.dispatch.events.EmployeeAddedToMachine;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.events.LinkedPosition;
import co.com.sofka.production.employee.usecases.CreatePositionUseCase;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreatePositionUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    CreatePositionUseCase useCase;
    
    @Test
    void createPosition(){
        //arrange
        EmployeeId employeeId = new EmployeeId();

        when(repository.getEventsBy(employeeId.value())).thenReturn(employeeHist());
        useCase.addRepository(repository);


        var name = new Name("Toast Operator");
        var description = new Description("Employee that works with the toast machine");
        var salary = new Salary(1000);
        var employee = Employee.from(employeeId, repository.getEventsBy(employeeId.value()));

        var event = new EmployeeAddedToMachine(employee, name, description, salary, MachineId.of("toast"));

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventAnswer = (LinkedPosition) events.get(0);
        Assertions.assertEquals("Toast Operator", eventAnswer.getName().value());
        Assertions.assertEquals(1000, eventAnswer.getSalary().value());
    } 

    private List<DomainEvent> employeeHist() {
        Fullname fullname = new Fullname("Jose Daniel", "Cruz Ávila");
        Address address = new Address("Colombia", "Manizales", "Cra 2");
        
        return List.of(
                new CreatedEmployee(fullname, address, new StartDate())
                );
    }
}
