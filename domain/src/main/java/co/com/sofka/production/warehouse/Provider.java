package co.com.sofka.production.warehouse;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.production.general.values.Address;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.BagAmmount;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Class with the logic for manage the provider information
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class Provider extends Entity<ProviderId> {
    private Name name;
    private Address address;
    private BagAmmount bagAmmount;

    public Provider(ProviderId entityId, Name name, Address address) {
        super(entityId);
        this.name = name;
        this.address = address;
    }

    /**
     * Method for update the provider name
     * 
     * @param name the updated name
     */
    public void changeName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

     /**
     * Method for update the provider address
     * 
     * @param address the updated address
     */
    public void changeAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

     /**
     * Method for update the provider bag ammount
     * 
     * @param address the updated address
     */
    public void changeBagAmmount(BagAmmount bagAmmount) {
        this.bagAmmount = Objects.requireNonNull(bagAmmount);
    }

    protected Name name() {
        return name;
    }

    protected Address address() {
        return address;
    }

    protected BagAmmount bagAmmount() {
        return bagAmmount;
    } 

}
