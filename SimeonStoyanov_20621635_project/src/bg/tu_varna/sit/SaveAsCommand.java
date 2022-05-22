package bg.tu_varna.sit;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) {

        if (args.length == 0) {
            System.out.println("saveassed...\n");
        }
    }
}

