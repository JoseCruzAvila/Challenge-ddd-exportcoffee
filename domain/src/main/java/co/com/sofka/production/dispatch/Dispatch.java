package co.com.sofka.production.dispatch;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.production.dispatch.events.AddedDelivery;
import co.com.sofka.production.dispatch.events.AddedMachine;
import co.com.sofka.production.dispatch.events.ClientAddedToDelivery;
import co.com.sofka.production.dispatch.events.CoffeeBagAddedToDelivery;
import co.com.sofka.production.dispatch.events.CreatedClient;
import co.com.sofka.production.dispatch.events.CreatedDispatch;
import co.com.sofka.production.dispatch.events.EmployeeAddedToMachine;
import co.com.sofka.production.dispatch.events.EstablishedWarehouse;
import co.com.sofka.production.dispatch.events.ScheduleModified;
import co.com.sofka.production.dispatch.events.TreatedCoffee;
import co.com.sofka.production.dispatch.events.UpdatedClientAddress;
import co.com.sofka.production.dispatch.events.UpdatedClientName;
import co.com.sofka.production.dispatch.events.UpdatedDeliverDescription;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.dispatch.values.DeliveryId;
import co.com.sofka.production.dispatch.values.DispatchId;
import co.com.sofka.production.dispatch.values.MachineId;
import co.com.sofka.production.dispatch.values.Schedule;
import co.com.sofka.production.dispatch.values.Type;
import co.com.sofka.production.employee.Employee;
import co.com.sofka.production.employee.values.Salary;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Description;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.Warehouse;

/**
 * Class with the logic for manage all the dispatch info
 * 
 * @author Jose Cruz
 * @version 2.0
 */
public class Dispatch extends AggregateEvent<DispatchId> {
    protected Schedule schedule;
    protected Map<Machine, Set<Employee>> employeesByMachine;
    protected Set<Delivery> deliveries;
    protected Set<Client> clients;
    protected Warehouse warehouse;

    public Dispatch(DispatchId entityId, Schedule schedule) {
        super(entityId);
        appendChange(new CreatedDispatch(schedule)).apply();
    }

    private Dispatch(DispatchId entityId) {
        super(entityId);
        subscribe(new DispatchChange(this));
    }

    public static Dispatch from(DispatchId entityId, List<DomainEvent> events) {
        var dispatch = new Dispatch(entityId);
        events.forEach(dispatch::applyEvent);
        
        return dispatch;
    }

    /**
     * Method for update the schedule of a dispatch
     * 
     * @param schedule the new schedule
     */
    public void modifySchedule(Schedule schedule) {
        Objects.requireNonNull(schedule);

        appendChange(new ScheduleModified(schedule)).apply();
    }

    /**
     * Method for add a nre employee to a machine
     * 
     * @param employeeId the employee id
     * @param fullname the fullname of the employee
     * @param address the employee address
     * @param positionName the new position of the employee
     * @param positionDescription the description of the position
     * @param salary the position salary
     * @param machineId the machine id
     */
    public void addEmployeeToMachine(Employee employee, Name positionName, Description positionDescription, Salary salary, MachineId machineId) {
        Objects.requireNonNull(employee);
        Objects.requireNonNull(positionName);
        Objects.requireNonNull(positionDescription);
        Objects.requireNonNull(salary);
        Objects.requireNonNull(machineId);

        appendChange(new EmployeeAddedToMachine(employee, positionName, positionDescription, salary, machineId)).apply();
    }

    /**
     * Method for create a new machine
     * 
     * @param machineId the machine id
     * @param type the machine type: toast or grind
     */
    public void addMachine(MachineId machineId, Type type) {
        Objects.requireNonNull(machineId);
        Objects.requireNonNull(type);

        appendChange(new AddedMachine(machineId, type)).apply();
    }

    /**
     * Method for create a new delivery
     * 
     * @param deliveryId the delivery id
     * @param description the delivery description
     */
    public void addDelivery(DeliveryId deliveryId, Description description) {
        Objects.requireNonNull(deliveryId);
        Objects.requireNonNull(description);

        appendChange(new AddedDelivery(deliveryId, description)).apply();
    }

    /**
     * Method for create a new client
     * 
     * @param clientId the client id
     * @param name the client name
     * @param address the client address
     */
    public void createClient(ClientId clientId, Name name, Address address) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);

        appendChange(new CreatedClient(clientId, name, address)).apply();
    }

    /**
     * Method for asign a client to a deliver
     * 
     * @param clientId the client id
     * @param deliveryId the delivery id
     */
    public void addClientToDeliver(ClientId clientId, DeliveryId deliveryId) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(deliveryId);

        appendChange(new ClientAddedToDelivery(clientId, deliveryId)).apply();
    }

    /**
     * Method for asign a warehouse to a dispatch
     * 
     * @param warehouse the warehouse
     */
    public void establishWarehouse(Warehouse warehouse) {
        Objects.requireNonNull(warehouse);

        appendChange(new EstablishedWarehouse(warehouse)).apply();
    }

    /**
     * Method for make the treatment of the coffee in a machine
     * 
     * @param coffeToTreat quantity of coffee bags to treat
     * @param machineType type of the machine to use
     */
    public void treatCoffee(int coffeeToTreat, Type machineType) {
        Objects.requireNonNull(coffeeToTreat);
        Objects.requireNonNull(machineType);

        appendChange(new TreatedCoffee(coffeeToTreat, machineType)).apply();
    }

    /**
     * Method for add a coffee bag to a delivery
     * 
     * @param deliveryId the delivery to add de bag
     */
    public void addCoffeeBagToDeliver(DeliveryId deliveryId) {
        Objects.requireNonNull(deliveryId);

        appendChange(new CoffeeBagAddedToDelivery(deliveryId)).apply();
    }

    /**
     * Method for update the delivery description
     * 
     * @param deliveryId the delivery id 
     * @param description the delivery description
     */
    public void updateDeliverDescription(DeliveryId deliveryId, Description description) {
        Objects.requireNonNull(deliveryId);
        Objects.requireNonNull(description);

        appendChange(new UpdatedDeliverDescription(deliveryId, description)).apply();
    }

    /**
     * Method for update a client name by Id
     * 
     * @param clientId the client id
     * @param name the client name
     */
    public void updateClientName(ClientId clientId, Name name) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);

        appendChange(new UpdatedClientName(clientId, name)).apply();
    }

    /**
     * Method for update a client address with the client id
     * 
     * @param clientId the client id
     * @param address the client address
     */
    public void updateClientAddress(ClientId clientId, Address address) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(address);

        appendChange(new UpdatedClientAddress(clientId, address)).apply();
    }

    /**
     * Function that allows to get a delivery by its id
     * 
     * @param entityId the delivery id
     * @return the delivery if it exists
     */
    public Optional<Delivery> getDeliveryById(DeliveryId entityId) {
        return deliveries().stream()
                           .filter(delivery -> delivery.identity().equals(entityId))
                           .findFirst();
    }

    /**
     * Function that allows to get a machine by its id
     * 
     * @param entityId the machine id
     * @return the machine if it exists
     */
    public Optional<Machine> getMachineById(MachineId entityId) {
        return employeesByMachine().keySet()
                                   .stream()
                                   .filter(machine -> machine.identity().equals(entityId))
                                   .findFirst();
    }

     /**
     * Function that allows to get a machine by its type
     * 
     * @param type the machine type
     * @return the machine if it exists
     */
    public Optional<Machine> getMachineByType(Type type) {
        return employeesByMachine().keySet()
                                   .stream()
                                   .filter(machine -> machine.type().equals(type))
                                   .findFirst();
    }

    /**
     * Function that allows to get a client by its id
     * 
     * @param entityId the client id
     * @return the client if it exists
     */
    public Optional<Client> getClientById(ClientId entityId) {
        return clients().stream()
                           .filter(client -> client.identity().equals(entityId))
                           .findFirst();
    }

    public Schedule schedule() {
        return schedule;
    }

    public Map<Machine, Set<Employee>> employeesByMachine() {
        return employeesByMachine;
    }

    public Set<Delivery> deliveries() {
        return deliveries;
    }

    public Set<Client> clients() {
        return clients;
    }

    public Warehouse warehouse() {
        return warehouse;
    }
   
}
