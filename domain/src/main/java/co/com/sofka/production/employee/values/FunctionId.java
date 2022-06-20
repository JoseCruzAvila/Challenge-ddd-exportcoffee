package co.com.sofka.production.employee.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of an employee function
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class FunctionId extends Identity {
    public FunctionId() {

    }

    private FunctionId(String id) {
        super(id);
    }

    public static FunctionId of(String id) {
        return new FunctionId(id);
    }
}
