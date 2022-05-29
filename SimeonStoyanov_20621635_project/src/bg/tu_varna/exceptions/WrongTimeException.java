package bg.tu_varna.exceptions;

public class WrongTimeException extends Exception{
    public WrongTimeException(){
        System.out.println("This time window is booked");
    }
}
