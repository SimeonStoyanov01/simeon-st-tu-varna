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

            System.out.println("Successfully opened file.xml");
            System.out.println(o);
            System.out.println("Successfully opened file.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}