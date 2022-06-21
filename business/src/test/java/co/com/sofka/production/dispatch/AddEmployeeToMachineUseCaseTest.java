package co.com.sofka.production.dispatch;

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
import co.com.sofka.production.dispatch.commands.AddEmployeeToMachine;
import co.com.sofka.production.dispatch.events.AddedMachine;
import co.com.sofka.production.dispatch.events.CreatedDispatch;
import co.com.sofka.production.dispatch.events.EmployeeAddedToMachine;
import co.com.sofka.production.dispatch.usecases.AddEmployeeToMachineUseCase;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.dispatch.values.Schedule;
import co.com.sofka.production.dispatch.values.Type;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class AddEmployeeToMachineUseCaseTest {
    @Mock
    DomainEventRepository repository;
    
    @InjectMocks
    AddEmployeeToMachineUseCase useCase;

    @Test
    void addEmployeeToMachine() {

        //arrange
        var dispatchId = new DispatchId();
        var machineId = new MachineId();
        var employeeId = new EmployeeId();
        var name = new Name("Toast Operator");
        var description = new Description("Employee that works with the toast machine");
        var salary = new Salary(1000);

        when(repository.getEventsBy(dispatchId.value())).thenReturn(history(dispatchId, machineId));
        useCase.addRepository(repository);

        when(repository.getEventsBy(employeeId.value())).thenReturn(historyEmployee(employeeId));
        useCase.addRepository(repository);

        var command = new AddEmployeeToMachine(dispatchId, employeeId, name, description, salary, machineId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EmployeeAddedToMachine) events.get(0);
        Assertions.assertEquals(machineId, event.getMachineId());
        Assertions.assertEquals(1000, event.getSalary().value());
    } 

    private List<DomainEvent> history(DispatchId dispatchId, MachineId machineId) {
        var days = Set.of(
            Schedule.Days.MO,
            Schedule.Days.TU,
            Schedule.Days.WE,
            Schedule.Days.TH,
            Schedule.Days.FR
        );
        Schedule schedule = new Schedule(days, LocalTime.of(8, 0), LocalTime.of(16, 0));

        return List.of(
                new CreatedDispatch(dispatchId, schedule),
                new AddedMachine(machineId, new Type(Type.Machine.TOAST))
                );
    }

    private List<DomainEvent> historyEmployee(EmployeeId employeeId) {
        Fullname fullname = new Fullname("Jose Daniel", "Cruz Ávila");
        Address address = new Address("Colombia", "Manizales", "Cra 2");

        return List.of(
                new CreatedEmployee(fullname, address, new StartDate())
                );
    }
}
