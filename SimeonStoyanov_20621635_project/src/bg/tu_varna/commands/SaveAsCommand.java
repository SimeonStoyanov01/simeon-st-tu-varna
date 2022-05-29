package bg.tu_varna.commands;

import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.exceptions.FileNotOpenedException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

public class SaveAsCommand implements Command {
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        JAXBContext jaxbContext = null;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Pick a file name: ");
            String file1=scanner.nextLine();



            jaxbContext = JAXBContext.newInstance(AppointmentsCalendar.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(createCompanyObject(), new File(file1));
            System.out.println("Successfully saved in "+ file1.toString());
            jaxbMarshaller.marshal(createCompanyObject(), System.out);
            System.out.println("Successfully saved in "+ file1.toString());



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

