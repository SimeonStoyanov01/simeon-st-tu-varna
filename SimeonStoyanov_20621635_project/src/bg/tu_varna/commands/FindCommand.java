package bg.tu_varna.commands;

import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.exceptions.FileNotOpenedException;

import java.text.ParseException;
import java.util.Scanner;

public class FindCommand implements Command {

    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
        if (!OpenCommand.flagOpen) {
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for a booking with a certain name or a specific note");
        String occurrence=scanner.nextLine();
        AppointmentsCalendar.find(occurrence);


    }
}