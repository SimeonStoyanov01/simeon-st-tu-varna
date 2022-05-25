package bg.tu_varna.sit;

import java.text.ParseException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ParseException {
        //Appointment appointment=new Appointment(10,11,2022,"11:15","12:15","Nails","very important");
           // appointment.getFormatStartTime();
        Scanner scanner = new Scanner(System.in);
        while(true){
            //getting user input
            System.out.print("Enter your command:");
            String userInput = scanner.nextLine();

            String[] splitedInput = userInput.split("[ ]+");

            //preparing data for creating and executing new command
            String commandName = splitedInput[0];
            Object[] commandArgs = new String[splitedInput.length-1];
            System.arraycopy(splitedInput,1,commandArgs,0,commandArgs.length);

            //executing command
            Command command =CommandFactory.getCommand(commandName);
            if(command!=null)
                command.execute(commandArgs);
            else
                System.out.println("Bad command. Try again or use help.");
        }
    }
}