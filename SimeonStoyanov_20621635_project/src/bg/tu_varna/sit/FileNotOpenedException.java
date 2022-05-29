package bg.tu_varna.sit;

public class FileNotOpenedException extends Exception{
    public FileNotOpenedException(){
        System.out.println("Open the file first");
    }
}
