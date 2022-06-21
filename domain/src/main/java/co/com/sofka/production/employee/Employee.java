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
 * @version 2.0
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

    /**
     * Method for change the employee fullname
     * 
     * @param fullanme the updated name
     */
    public void changeFullname(Fullname fullanme) {
        Objects.requireNonNull(fullname);

        appendChange(new ChangedFullname(fullname)).apply();
    }

    /**
     * Method for change the employee address
     * 
     * @param address the updated address
     */
    public void changeAddress(Address address) {
        Objects.requireNonNull(address);

        appendChange(new ChangedAddress(address)).apply();
    }

    /**
     * Method for asign a position to the employee
     * 
     * @param entityId the position id
     * @param name the position name
     * @param description the position description
     * @param salary the salary asigned to the position
     */
    public void addPosition(PositionId entityId, Name name, Description description, Salary salary) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(salary);

        appendChange(new LinkedPosition(entityId, name, description, salary)).apply();
    }

    /**
     * Method that add a new function to the employee functions
     * 
     * @param entityId the function id
     * @param name the name of the new function
     * @param description the description of the function
     */
    public void addFunction(FunctionId entityId, Name name, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

        appendChange(new CreatedFunction(entityId, name, description)).apply();
    }

    /**
     * Method that establish the end date of the employee in the company
     * 
     * @param endDate the end date eith the reason for which the employee will leave the company
     */
    public void setEndDate(EndDate endDate) {
        Objects.requireNonNull(endDate);

        appendChange(new EstablishedEndDate(endDate)).apply();
    }

    /**
     * Method that update the name of one employee function
     * 
     * @param entityId the function id
     * @param name the new name
     */
    public void updateFunctionNameById(FunctionId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);

        appendChange(new UpdatedFunctionName(entityId, name)).apply();
    }

    /**
     * Method that update the description of one employee function
     * 
     * @param entityId the function id
     * @param description the new description
     */
    public void updateFunctionDescriptionById(FunctionId entityId, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(description);

        appendChange(new UpdatedFunctionDescription(entityId, description)).apply();
    }

    /**
     * Method that update the position name of the employee in the company
     * 
     * @param name the new name
     */
    public void updatePositionName(Name name) {
        Objects.requireNonNull(name);

        appendChange(new UpdatedPositionName(name)).apply();
    }

    /**
     * Method that update the position description of the employee in the company
     * 
     * @param description the new description
     */
    public void updatePositionDescription(Description description) {
        Objects.requireNonNull(description);

        appendChange(new UpdatedPositionDescription(description)).apply();
    }

    /**
     * Method that update the position salary of the employee in the company
     * 
     * @param salary the new salary
     */
    public void updatePositionSalary(Salary salary) {
        Objects.requireNonNull(salary);

        appendChange(new UpdatedPositionSalary(salary)).apply();
    }

    /**
     * Function that allows to get a function by its id
     * 
     * @param entityId the function id
     * @return the function if it exists
     */
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
