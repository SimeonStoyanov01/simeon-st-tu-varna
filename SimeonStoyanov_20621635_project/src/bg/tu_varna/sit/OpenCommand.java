package bg.tu_varna.sit;


import java.util.Arrays;
public class OpenCommand implements Command{
    public static boolean openedFile = false;
    public static String filePath;
    public static String fileName;

    @Override
    public void execute(Object[] args) {/*
        if(args.length==0){
            System.out.println("saved");
        }
        filePath = String.join(" ", Arrays.stream(args).toArray(String[]::new));

        StudentServiceSystem.setSystemInstance(JaxXMLToObject.jaxbXmlFileToObject(filePath));
        openedFile=true;

        fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
        System.out.println("Successfully opened " + fileName);*/
    }
}