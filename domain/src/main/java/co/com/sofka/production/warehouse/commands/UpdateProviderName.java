package co.com.sofka.production.warehouse.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.general.values.Name;
import co.com.sofka.production.warehouse.values.ProviderId;

/**
 * Class that acts like a command for update a provider name
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class UpdateProviderName extends Command {
    private final ProviderId providerId;
    private final Name name;

    public UpdateProviderName(ProviderId providerId, Name name) {
        this.providerId = providerId;
        this.name = name;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName() {
        return name;
    }
}
