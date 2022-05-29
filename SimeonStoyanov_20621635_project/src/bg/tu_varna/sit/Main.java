package bg.tu_varna.sit;

import bg.tu_varna.commands.Command;
import bg.tu_varna.commands.CommandFactory;
import bg.tu_varna.exceptions.FileNotOpenedException;

import java.text.ParseException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ParseException, FileNotOpenedException {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter your command: \n >");
            String userInput = scanner.nextLine();

            String[] splitedInput = userInput.split("[ ]+");

            String commandName = splitedInput[0];
            Object[] commandArgs = new String[splitedInput.length-1];
            System.arraycopy(splitedInput,1,commandArgs,0,commandArgs.length);

            Command command = CommandFactory.getCommand(commandName);
            if(command!=null)
                command.execute(commandArgs);
            else
                System.out.println("Bad command. Try again or use help.");
        }
    }
}