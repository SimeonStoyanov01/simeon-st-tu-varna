package bg.tu_varna.sit;

public abstract class CommandFactory {
    public static Command getCommand(String commandName){
        if(commandName.equalsIgnoreCase("open")){
            return new OpenCommand();
        }else if(commandName.equalsIgnoreCase("exit")){
            return new ExitCommand();
        }else if(commandName.equalsIgnoreCase("help")){
            return new HelpCommand();
        }else if(commandName.equalsIgnoreCase("save")){
            return new SaveCommand();
        }else if(commandName.equalsIgnoreCase("save as")){
            return new SaveAsCommand();
        }else if(commandName.equalsIgnoreCase("close")){
            return new CloseCommand();
        }else if(commandName.equalsIgnoreCase("book")){
            return new BookCommand();
        }else if(commandName.equalsIgnoreCase("unbook")){
            return new UnbookCommand();}
        else{
            return null;
        }
    }
}