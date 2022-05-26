package bg.tu_varna.sit;

import java.text.ParseException;
import java.util.Scanner;

public class UnbookCommand implements Command{
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
        AppointmentsCalendar.unbook(day,month,year,startTime,endTime);

        AppointmentsCalendar.all();


    }
}
