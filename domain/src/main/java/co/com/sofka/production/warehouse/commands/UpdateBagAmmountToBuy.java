package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.warehouse.values.BagAmmount;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Class that acts like a command for upcate the coffee amount to buy
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateBagAmmountToBuy extends Command {
    private final ProviderId providerId;
    private final BagAmmount bagAmmount;

    public UpdateBagAmmountToBuy(ProviderId clientId, BagAmmount bagAmmount) {
        this.providerId = clientId;
        this.bagAmmount = bagAmmount;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public BagAmmount getBagAmmount() {
        return bagAmmount;
    }
}
