package co.com.sofka.production.employee.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.commands.FinishEmployeeContractCommand;

public class FinishEmployeeContractUseCase extends UseCase<RequestCommand<FinishEmployeeContractCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<FinishEmployeeContractCommand> input) {
        var command = input.getCommand();
        var employee = Employee.from(command.getEmployeeId(), repository().getEventsBy(command.getEmployeeId().value()));

        employee.setEndDate(command.getEndDate());
        
        emit().onResponse(new ResponseEvents(employee.getUncommittedChanges()));
    }
    
}
