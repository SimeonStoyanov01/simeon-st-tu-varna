package bg.tu_varna.sit;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) {

        if (args.length == 0) {
            System.out.println("saved...\n");
        }
    }
}
