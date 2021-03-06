package bg.tu_varna.commands;

import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.exceptions.FileNotOpenedException;

import java.util.Scanner;

public class AgendaCommand implements Command {
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if (!OpenCommand.flagOpen) {
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a date: dd/MM/yyyy");
        String date = scanner.nextLine();
        AppointmentsCalendar.agenda(date);
    }
}