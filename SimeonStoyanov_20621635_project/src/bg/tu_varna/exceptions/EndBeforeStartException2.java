package bg.tu_varna.exceptions;

public class EndBeforeStartException2 extends Exception{
    public EndBeforeStartException2(){
        System.out.println("End date can't be before start time");
    }
}
