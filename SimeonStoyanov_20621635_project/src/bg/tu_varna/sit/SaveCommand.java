package bg.tu_varna.sit;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SaveCommand implements Command {
    public void execute(Object[] args) throws ParseException {

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

            jaxbMarshaller.marshal(createCompanyObject(), System.out);

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


        /*Appointment o1 = new Appointment();
        o1.setName("Nails");
        o1.setNote("Important");
        o1.setStartTime(new SimpleDateFormat("HH:mm").parse("12:15"));
        o1.setEndTime(new SimpleDateFormat("HH:mm").parse("13:15"));
        o1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2022"));

        Appointment o2 = new Appointment();
        o2.setName("Hair");
        o2.setNote("Important");
        o2.setStartTime(new SimpleDateFormat("HH:mm").parse("14:15"));
        o2.setEndTime(new SimpleDateFormat("HH:mm").parse("15:15"));
        o2.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2022"));
        comp.setAppointmentArrayList(Arrays.asList(o1, o2));*/

        return comp;
    }


}