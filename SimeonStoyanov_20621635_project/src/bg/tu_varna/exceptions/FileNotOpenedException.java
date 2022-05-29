package bg.tu_varna.exceptions;

public class FileNotOpenedException extends Exception{
    public FileNotOpenedException(){
        System.out.println("Open the file first");
    }
}
