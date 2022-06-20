package co.com.sofka.production.employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.EndDate;
import co.com.sofka.production.employee.values.Fullname;
import co.com.sofka.production.employee.values.FunctionId;
import co.com.sofka.production.employee.values.PositionId;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.employee.values.StartDate;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;

/**
 * Class with the logic for manage all the employee info
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Employee extends AggregateEvent<EmployeeId> {
    protected Fullname fullname;
    protected Address address;
    protected Position position;
    protected Set<Function> functions;
    protected StartDate startDate;
    protected EndDate endDate;

    public Employee(EmployeeId entityId, Fullname fullname, Address address) {
        super(entityId);
        appendChange(new CreatedEmployee(fullname, address, new StartDate())).apply();
    }

    private Employee(EmployeeId entityId) {
        super(entityId);
        subscribe(new EmployeeChange(this));
    }

    public static Employee from(EmployeeId entityId, List<DomainEvent> events) {
        var employee = new Employee(entityId);
        events.forEach(employee::applyEvent);
        
        return employee;
    }

    public void changeFullname(Fullname fullanme) {
        Objects.requireNonNull(fullname);

        appendChange(new ChangedFullname(fullname)).apply();
    }

    public void changeAddress(Address address) {
        Objects.requireNonNull(address);

        appendChange(new ChangedAddress(address)).apply();
    }

    public void addPosition(PositionId entityId, Name name, Description description, Salary salary) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(salary);

        appendChange(new LinkedPosition(entityId, name, description, salary)).apply();
    }

    public void addFunction(FunctionId entityId, Name name, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

        appendChange(new CreatedFunction(entityId, name, description)).apply();
    }

    public void setEndDate(EndDate endDate) {
        Objects.requireNonNull(endDate);

        appendChange(new EstablishedEndDate(endDate)).apply();
    }

    public void updateFunctionNameById(FunctionId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);

        appendChange(new UpdatedFunctionName(entityId, name)).apply();
    }

    public void updateFunctionDescriptionById(FunctionId entityId, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(description);

        appendChange(new UpdatedFunctionDescription(entityId, description)).apply();
    }

    public void updatePositionName(Name name) {
        Objects.requireNonNull(name);

        appendChange(new UpdatedPositionName(name)).apply();
    }

    public void updatePositionDescription(Description description) {
        Objects.requireNonNull(description);

        appendChange(new UpdatedPositionDescription(description)).apply();
    }

    public void updatePositionSalary(Salary salary) {
        Objects.requireNonNull(salary);

        appendChange(new UpdatedPositionSalary(salary)).apply();
    }

    public Optional<Function> getFunctionById(FunctionId entityId) {
        return functions().stream()
                          .filter(function -> function.identity().equals(entityId))
                          .findFirst();
    }

    public Fullname fullname() {
        return fullname;
    }

    public Address address() {
        return address;
    }

    public Position position() {
        return position;
    }

    public Set<Function> functions() {
        return functions;
    }

    public StartDate startDate() {
        return startDate;
    }

    public EndDate endDate() {
        return endDate;
    }
    
}
