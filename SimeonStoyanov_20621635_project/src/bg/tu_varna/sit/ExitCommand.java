package bg.tu_varna.sit;

public class ExitCommand implements Command {

    @Override
    public void execute(Object[] args) {
        if(args.length!=0){
            System.out.println("No reason to give me parameters, anyway I'll ignore them");
        }
        System.exit(0);
    }
}
