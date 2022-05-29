package bg.tu_varna.commands;

import bg.tu_varna.commands.Command;
import bg.tu_varna.commands.OpenCommand;
import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.sit.FileNotOpenedException;

import java.text.ParseException;
import java.util.Scanner;

public class UnbookCommand implements Command {
    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a date: dd/MM/yyyy");
        String date=scanner.nextLine();

        //int day=scanner.nextInt();
        //int month=scanner.nextInt();
        //int year=scanner.nextInt();
       // scanner.nextLine();
        System.out.println("Start of appointment:");
        String startTime=scanner.nextLine();
        System.out.println("End of appointment: ");
        String endTime=scanner.nextLine();
        AppointmentsCalendar.unbook(date,startTime,endTime);

        AppointmentsCalendar.all();
        System.out.println("Appointment unbooked");


    }
}
