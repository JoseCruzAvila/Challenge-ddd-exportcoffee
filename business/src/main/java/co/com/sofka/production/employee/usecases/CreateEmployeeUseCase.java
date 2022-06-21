package co.com.sofka.production.employee.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.commands.CreateEmployeeCommand;

public class CreateEmployeeUseCase extends UseCase<RequestCommand<CreateEmployeeCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateEmployeeCommand> input) {
        var event = input.getCommand();
        var employee = new Employee(event.getEmployeeId(), event.getFullname(), event.getAddress());
        
        emit().onResponse(new ResponseEvents(employee.getUncommittedChanges()));
    }
    
}
