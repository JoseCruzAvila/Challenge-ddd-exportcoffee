package co.com.sofka.production.employee;

import java.time.LocalDate;
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
import co.com.sofka.production.employee.commands.FinishEmployeeContractCommand;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.events.EstablishedEndDate;
import co.com.sofka.production.employee.usecases.FinishEmployeeContractUseCase;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.EndDate;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinishEmployeeContractUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    FinishEmployeeContractUseCase useCase;

    @Test
    void endEmployeeContract() {
        // arrange
        EmployeeId id = new EmployeeId();
        var endDate = new EndDate(LocalDate.now(), "Finish of the contract period");
        var command = new FinishEmployeeContractCommand(id, endDate);

        when(repository.getEventsBy(id.value())).thenReturn(employeeHist());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var event = (EstablishedEndDate) events.get(0);
        Assertions.assertTrue(event.getEndDate().value().containsValue("Finish of the contract period"));
    }

    private List<DomainEvent> employeeHist() {
        Fullname fullname = new Fullname("Jose Daniel", "Cruz Ávila");
        Address address = new Address("Colombia", "Manizales", "Cra 2");

        return List.of(
                new CreatedEmployee(fullname, address, new StartDate()));
    }
}
