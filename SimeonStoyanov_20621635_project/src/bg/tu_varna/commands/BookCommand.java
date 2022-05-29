package bg.tu_varna.commands;

import bg.tu_varna.sit.*;

import java.text.ParseException;
import java.util.*;

public class BookCommand implements Command {

    @Override
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
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
        } catch (WrongTimeException e) {
            e.printStackTrace();
        }

        //int days=a.getDate().get(Calendar.DAY_OF_WEEK);
        //System.out.println(days);

        AppointmentsCalendar.all();
        System.out.println("Appointment booked");

    }
}
