package bg.tu_varna.exceptions;

public class EndBeforeStartException extends Exception{
    public EndBeforeStartException(){
        System.out.println("End time can't be before start time");
    }
}
