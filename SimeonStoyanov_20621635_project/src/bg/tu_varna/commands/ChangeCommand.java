package bg.tu_varna.commands;

import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.sit.FileNotOpenedException;

import java.text.ParseException;
import java.util.Scanner;

public class ChangeCommand implements Command {
    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a date: dd/MM/yyyy");
        String date=scanner.nextLine();
        System.out.println("Start of appointment:");
        String startTime=scanner.nextLine();
        System.out.println("Pick a parameter for change: date,starttime,endtime,name,note ");
        String option=scanner.nextLine();
        System.out.println("Enter a new value ");
        String newValue = scanner.nextLine();
        AppointmentsCalendar.change(date,startTime,option,newValue);
        AppointmentsCalendar.all();
        System.out.println("Appointment parameters changed");
    }
}
