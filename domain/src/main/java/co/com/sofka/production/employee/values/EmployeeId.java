package co.com.sofka.production.employee.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Value object that works like the identity of an employee
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class EmployeeId extends Identity {
    
    public EmployeeId() {

    }

    private EmployeeId(String id) {
        super(id);
    }

    public static EmployeeId of(String id) {
        return new EmployeeId(id);
    }
}
