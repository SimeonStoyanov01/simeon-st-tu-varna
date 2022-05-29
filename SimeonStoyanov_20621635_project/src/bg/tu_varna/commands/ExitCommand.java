package bg.tu_varna.commands;

import bg.tu_varna.commands.Command;
import bg.tu_varna.sit.FileNotOpenedException;

public class ExitCommand implements Command {

    @Override
    public void execute(Object[] args) throws FileNotOpenedException {

            System.out.println("Have a nice day...");

        System.exit(0);
    }
}
