package co.com.sofka.production.employee;

import java.util.HashSet;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.production.employee.events.ChangedAddress;
import co.com.sofka.production.employee.events.ChangedFullname;
import co.com.sofka.production.employee.events.CreatedEmployee;
import co.com.sofka.production.employee.events.CreatedFunction;
import co.com.sofka.production.employee.events.EstablishedEndDate;
import co.com.sofka.production.employee.events.LinkedPosition;
import co.com.sofka.production.employee.events.UpdatedFunctionDescription;
import co.com.sofka.production.employee.events.UpdatedFunctionName;
import co.com.sofka.production.employee.events.UpdatedPositionDescription;
import co.com.sofka.production.employee.events.UpdatedPositionName;
import co.com.sofka.production.employee.events.UpdatedPositionSalary;

/**
 * Class that get all the events applied over an employee and make changes from these
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EmployeeChange extends EventChange {
    public EmployeeChange(Employee employee) {
        apply((CreatedEmployee event) -> {
            employee.fullname = event.getFullname();
            employee.address = event.getAddress();
            employee.functions = new HashSet<>();
            employee.startDate = event.getStartDate();
        });

        apply((ChangedFullname event) -> {
            employee.fullname = event.getFullname();
        });

        apply((ChangedAddress event) -> {
            employee.address = event.getAddress();
        });

        apply((LinkedPosition event) -> {
            employee.position = new Position(event.getPositionId(), event.getName(), event.getDescription(), event.getSalary());
        });

        apply((CreatedFunction event) -> {
            employee.functions.add(new Function(event.getFunctionId(), event.getName(), event.getDescription()));
        });

        apply((EstablishedEndDate event) -> {
            employee.endDate = event.getEndDate();
        });

        apply((UpdatedFunctionName event) -> {
            var function = employee.getFunctionById(event.getFunctionId())
                                   .orElseThrow(() -> new IllegalArgumentException("The given funtion doesn't exist"));
            function.changeName(event.getName());
        });

        apply((UpdatedFunctionDescription event) -> {
            var function = employee.getFunctionById(event.getFunctionId())
                                   .orElseThrow(() -> new IllegalArgumentException("The given funtion doesn't exist"));
            function.changeDescription(event.getDescription());
        });

        apply((UpdatedPositionName event) -> {
            employee.position.changeName(event.getName());
        });

        apply((UpdatedPositionDescription event) -> {
            employee.position.changeDescription(event.getDescription());
        });

        apply((UpdatedPositionSalary event) -> {
            employee.position.changeSalary(event.getSalary());
        });
    }
}
