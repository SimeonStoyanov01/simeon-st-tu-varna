package bg.tu_varna.commands;

import bg.tu_varna.exceptions.EndBeforeStartException;
import bg.tu_varna.exceptions.FileNotOpenedException;
import bg.tu_varna.exceptions.HolidayException;
import bg.tu_varna.exceptions.WrongTimeException;
import bg.tu_varna.sit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookCommand implements Command {

    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException, HolidayException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a date: dd/MM/yyyy");
        String date=scanner.nextLine();

       // int day=scanner.nextInt();
        //int month=scanner.nextInt();
        //int year=scanner.nextInt();
        //scanner.nextLine();
        System.out.println("Start of appointment:");
        String startTime=scanner.nextLine();
        System.out.println("End of appointment: ");
        String endTime=scanner.nextLine();
        System.out.println("Name of appointment: ");
        String name = scanner.nextLine();
        System.out.println("Note: ");
        String note=scanner.nextLine();

        Appointment a=new Appointment(date,startTime,endTime,name,note);

        try {
            AppointmentsCalendar.addToCollection(a);
            AppointmentsCalendar.all();
            System.out.println("Appointment booked");
        } catch (WrongTimeException | EndBeforeStartException e) {
            System.out.println(e);
        }





    }
}
