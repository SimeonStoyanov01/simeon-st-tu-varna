package bg.tu_varna.sit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BookCommand implements Command{

    @Override
    public void execute(Object[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a date: dd/MM/yyyy");

        int day=scanner.nextInt();
        int month=scanner.nextInt();
        int year=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Start of appointment:");
        String startTime=scanner.nextLine();
        System.out.println("End of appointment: ");
        String endTime=scanner.nextLine();
        System.out.println("Name of appointment: ");
        String name = scanner.nextLine();
        System.out.println("Note: ");
        String note=scanner.nextLine();

        Appointment a=new Appointment(day,month,year,startTime,endTime,name,note);
        AppointmentsCalendar.addToCollection(a);

        //int days=a.getDate().get(Calendar.DAY_OF_WEEK);
        //System.out.println(days);

        AppointmentsCalendar.all();

    }
}
