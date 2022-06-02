package bg.tu_varna.exceptions;

public class HolidayException extends Exception{
    public HolidayException(){
        System.out.println("This date is marked as a holiday");
    }
}
