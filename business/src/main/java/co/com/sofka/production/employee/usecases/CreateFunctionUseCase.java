package co.com.sofka.production.employee.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.commands.CreateFunctionCommand;

public class CreateFunctionUseCase extends UseCase<RequestCommand<CreateFunctionCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateFunctionCommand> input) {
        var command = input.getCommand();
        var employee = Employee.from(command.getEmployeeId(), repository().getEventsBy(command.getEmployeeId().value()));

        employee.addFunction(command.getFunctionId(), command.getName(), command.getDescription());
        
        emit().onResponse(new ResponseEvents(employee.getUncommittedChanges()));
    }
    
}
