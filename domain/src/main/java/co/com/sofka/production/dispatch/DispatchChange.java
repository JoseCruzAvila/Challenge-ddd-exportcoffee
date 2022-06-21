package co.com.sofka.production.dispatch;

import java.util.HashMap;
import java.util.HashSet;

import co.com.sofka.domain.generic.EventChange;
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
import co.com.sofka.production.dispatch.values.TreatCoffeeCount;

public class DispatchChange extends EventChange {
    public DispatchChange(Dispatch dispatch) {
        apply((CreatedDispatch event) -> {
            dispatch.schedule = event.getSchedule();
            dispatch.clients = new HashSet<>();
            dispatch.deliveries = new HashSet<>();
            dispatch.employeesByMachine = new HashMap<>();
        });

        apply((ScheduleModified event) -> {
            dispatch.schedule = event.getSchedule();
        });

        apply((EmployeeAddedToMachine event) -> {
            var machine = dispatch.getMachineById(event.getMachineId())
                                  .orElseThrow(() -> new IllegalArgumentException("The given machine id doesn't exist"));
            dispatch.employeesByMachine.get(machine).add(event.getEmployee());
        });

        apply((AddedMachine event) -> {
            dispatch.employeesByMachine.put(new Machine(event.getMachineId(), event.getType()), new HashSet<>());
        });

        apply((AddedDelivery event) -> {
            dispatch.deliveries.add(new Delivery(event.getDeliveryId(), event.getDescription()));
        });

        apply((CreatedClient event) -> {
            dispatch.clients.add(new Client(event.getClientId(), event.getName(), event.getAddress()));
        });

        apply((ClientAddedToDelivery event) -> {
            var delivery = dispatch.getDeliveryById(event.getDeliveryId())
                                   .orElseThrow(() -> new IllegalArgumentException("The given delivery doesn't exist"));
            
            delivery.addClient(event.getClientId());
        });

        apply((EstablishedWarehouse event) -> {
            dispatch.warehouse = event.warehouse();
        });

        apply((TreatedCoffee event) -> {
            var machine = dispatch.getMachineByType(event.getMachineType())
                                  .orElseThrow(() -> new IllegalArgumentException("There are no machines with this type"));

            machine.makeCoffeeTreatment(new TreatCoffeeCount(event.getCoffeeToTreat()));
        });

        apply((CoffeeBagAddedToDelivery event) -> {
            
        });

        apply((UpdatedDeliverDescription event) -> {
            var delivery = dispatch.getDeliveryById(event.getDeliveryId())
                                   .orElseThrow(() -> new IllegalArgumentException("The given delivery doesn't exist"));
        
            delivery.changeDescription(event.getDescription());
        });

        apply((UpdatedClientName event) -> {
            var client = dispatch.getClientById(event.getclientId())
                                 .orElseThrow(() -> new IllegalArgumentException("The given client doesn't exist"));;

            client.changeName(event.getName());
        });

        apply((UpdatedClientAddress event) -> {
            var client = dispatch.getClientById(event.getclientId())
                                 .orElseThrow(() -> new IllegalArgumentException("The given client doesn't exist"));;

            client.changeAddress(event.getAddress());
        });
        
    }
}
