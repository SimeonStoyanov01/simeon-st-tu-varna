package bg.tu_varna.commands;

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
        }else if(commandName.equalsIgnoreCase("saveas")){
            return new SaveAsCommand();
        }else if(commandName.equalsIgnoreCase("close")){
            return new CloseCommand();
        }else if(commandName.equalsIgnoreCase("book")){
            return new BookCommand();
        }else if(commandName.equalsIgnoreCase("unbook")){
            return new UnbookCommand();
        }else if(commandName.equalsIgnoreCase("agenda")){
            return new AgendaCommand();
        }else if(commandName.equalsIgnoreCase("find")){
            return new FindCommand();
        }else if(commandName.equalsIgnoreCase("holiday")){
            return new HolidayCommand();
        }else if(commandName.equalsIgnoreCase("change")){
            return new ChangeCommand();
        }else if(commandName.equalsIgnoreCase("busy")){
            return new BusyDaysCommand();
        }else if(commandName.equalsIgnoreCase("merge")){
            return new MergeCommand();
        }
        else{
            return null;
        }
    }
}