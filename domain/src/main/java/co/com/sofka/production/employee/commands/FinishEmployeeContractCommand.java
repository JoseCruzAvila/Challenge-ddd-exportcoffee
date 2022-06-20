package co.com.sofka.production.employee.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.employee.values.EmployeeId;
import co.com.sofka.production.employee.values.EndDate;

public class FinishEmployeeContractCommand extends Command {
    private final EmployeeId employeeId;
    private final EndDate endDate;

    public FinishEmployeeContractCommand(EmployeeId entityId, EndDate endDate) {
        this.employeeId = entityId;
        this.endDate = endDate;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }
    public EndDate getEndDate() {
        return endDate;
    }
}
