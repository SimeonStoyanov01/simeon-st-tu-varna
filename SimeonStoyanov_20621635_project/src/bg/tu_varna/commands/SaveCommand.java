package bg.tu_varna.commands;


import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.exceptions.FileNotOpenedException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.text.ParseException;

public class SaveCommand implements Command {
    public void execute(Object[] args) throws ParseException, FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }

        JAXBContext jaxbContext = null;
        try {

            //jaxbContext = JAXBContext.newInstance(Company.class);

            // EclipseLink MOXy needs jaxb.properties at the same package with Company.class or Staff.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
            jaxbContext = JAXBContext.newInstance(AppointmentsCalendar.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(createCompanyObject(), new File("file.xml"));
            System.out.println("Successfully saved in file.xml");
            jaxbMarshaller.marshal(createCompanyObject(), System.out);
            System.out.println("Successfully saved in file.xml");

            // XML Unmarshalling
            /*File file = new File("C:\\test\\company.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Company o = (Company) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);*/

        } catch (JAXBException | ParseException e) {
            e.printStackTrace();
        }

    }

    private static AppointmentsCalendar createCompanyObject() throws ParseException {

        AppointmentsCalendar comp = new AppointmentsCalendar();
        comp.setAppointmentArrayList(comp.getAppointmentArrayList());




        return comp;
    }


}