package co.com.sofka.production.dispatch.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.production.dispatch.values.Schedule;

/**
 * Class that acts like a command for update the dispatch schedule
 * 
 * @author Jose Cruz
 * @version 1.0
 */
public class ModifySchedule extends Command {
    private final Schedule schedule;

    public ModifySchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
