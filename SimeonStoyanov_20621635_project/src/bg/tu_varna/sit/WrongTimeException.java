package bg.tu_varna.sit;

public class WrongTimeException extends Exception{
    public WrongTimeException(){
        System.out.println("This time window is booked");
    }
}
