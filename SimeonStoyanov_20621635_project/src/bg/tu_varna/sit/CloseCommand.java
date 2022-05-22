package bg.tu_varna.sit;

public class CloseCommand implements Command{
    @Override
    public void execute(Object[] args) {

        if (args.length == 0) {
            System.out.println("closed...\n");
        }
    }
}

