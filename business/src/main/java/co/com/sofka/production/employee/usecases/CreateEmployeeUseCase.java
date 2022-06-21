package co.com.sofka.production.employee.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.production.dispatch.events.EmployeeAddedToMachine;
import co.com.sofka.production.employee.Employee;

public class CreateEmployeeUseCase extends UseCase<TriggeredEvent<EmployeeAddedToMachine>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EmployeeAddedToMachine> input) {
        var event = input.getDomainEvent();
        var employee = new Employee(event.getEmployeeId(), event.getFullname(), event.getAddress());
        
        emit().onResponse(new ResponseEvents(employee.getUncommittedChanges()));
    }
    
}
