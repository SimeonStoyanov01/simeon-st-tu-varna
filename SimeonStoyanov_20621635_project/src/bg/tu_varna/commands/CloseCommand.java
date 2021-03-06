package bg.tu_varna.commands;

import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.exceptions.FileNotOpenedException;

public class CloseCommand implements Command {
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        AppointmentsCalendar.getAppointmentArrayList().clear();
        OpenCommand.flagOpen=false;
        System.out.println("Progress is cleared");

    }
}

