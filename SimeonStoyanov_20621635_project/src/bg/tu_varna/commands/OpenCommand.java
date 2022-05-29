package bg.tu_varna.commands;


import bg.tu_varna.commands.Command;
import bg.tu_varna.sit.AppointmentsCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class OpenCommand implements Command {
    public static boolean flagOpen = false;

    @Override
    public void execute(Object[] args){

        JAXBContext jaxbContext = null;
        try {


            jaxbContext = JAXBContext.newInstance(AppointmentsCalendar.class);

            File file = new File("file.xml");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            AppointmentsCalendar o = (AppointmentsCalendar) jaxbUnmarshaller.unmarshal(file);
            flagOpen=true;


            System.out.println(o);
            System.out.println("Successfully opened file.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }/* {
        JAXBContext jaxbContext = null;
        try{

        if(args.length==0){
            System.out.println("saved");
        }
        filePath = String.join(" ", Arrays.stream(args).toArray(String[]::new));

        StudentServiceSystem.setSystemInstance(JaxXMLToObject.jaxbXmlFileToObject(filePath));
        openedFile=true;

        fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
        System.out.println("Successfully opened " + fileName);
        // XML Unmarshalling
            File file = new File("file.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            AppointmentsCalendar ac = (AppointmentsCalendar) jaxbUnmarshaller.unmarshal(file);
            System.out.println(ac);
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    }*/
}