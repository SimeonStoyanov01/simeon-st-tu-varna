package bg.tu_varna.commands;

import bg.tu_varna.exceptions.*;
import bg.tu_varna.sit.AppointmentsCalendar;

import java.text.ParseException;
import java.util.Scanner;

public class BusyDaysCommand implements Command {
    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
        if (!OpenCommand.flagOpen) {
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a starting date:");
        String from = scanner.nextLine();
        System.out.println("Pick an ending date");
        String to = scanner.nextLine();
        try{
            AppointmentsCalendar.busyDays(from,to);
           }
        catch(EndBeforeStartException2 e){
            System.out.println(e);
        }


    }
}