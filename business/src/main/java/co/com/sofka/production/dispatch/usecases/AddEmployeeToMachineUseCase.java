package co.com.sofka.production.dispatch.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.dispatch.Dispatch;
import co.com.sofka.production.dispatch.commands.AddEmployeeToMachine;
import co.com.sofka.production.employee.Employee;

public class AddEmployeeToMachineUseCase extends UseCase<RequestCommand<AddEmployeeToMachine>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddEmployeeToMachine> input) {
        var command = input.getCommand();
        var employee = Employee.from(command.getEmployeeId(), repository().getEventsBy(command.getEmployeeId().value()));
        var dispatch = Dispatch.from(command.getDispatchId(), repository().getEventsBy(command.getDispatchId().value()));

        dispatch.addEmployeeToMachine(employee, command.getPositionName(), command.getPositionDescription(), command.getSalary(), command.getMachineId());
        emit().onResponse(new ResponseEvents(dispatch.getUncommittedChanges()));
    }
    
}
