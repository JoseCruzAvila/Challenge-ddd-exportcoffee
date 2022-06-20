package co.com.sofka.production.employee.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of an employee position
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class PositionId extends Identity {
    public PositionId() {

    }

    private PositionId(String id) {
        super(id);
    }

    public static PositionId of(String id) {
        return new PositionId(id);
    }
}
