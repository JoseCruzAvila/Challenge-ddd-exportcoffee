package co.com.sofka.production.dispatch;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.dispatch.values.ClientId;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;

/**
 * Class with the logic for manage the client information
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Client extends Entity<ClientId> {
    private Name name;
    private Address address;

    public Client(ClientId entityId, Name name, Address address) {
        super(entityId);
        this.name = name;
        this.address = address;
    }

    /**
     * Method for update the client name
     * 
     * @param name the updated name
     */
    public void changeName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

     /**
     * Method for update the client address
     * 
     * @param address the updated address
     */
    public void changeAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

    public Name name() {
        return name;
    }

    public Address address() {
        return address;
    }
}
