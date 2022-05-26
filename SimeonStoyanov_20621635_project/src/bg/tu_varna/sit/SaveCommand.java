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

            jaxbMarshaller.marshal(createCompanyObject(), new File("fruit.xml"));

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


        Appointment o1 = new Appointment();
        String d1 = "12:15";
        int i1 = 2022;
        Date date1 = new SimpleDateFormat("HH:mm").parse(d1);
        GregorianCalendar gc1 = new GregorianCalendar();
        o1.setDate(gc1.set(Calendar.YEAR,i1));
        o1.setId(1);
        o1.setName("Banana");
        o1.setPrice("8.99");
        o1.setJoinDate(date1);

        Appointment o2 = new Appointment();
        o2.setId(1);
        o2.setDate();
        o2.setName("Tomato");
        o2.setPrice("2.99");
        o2.setJoinDate(date);
        comp.setList(Arrays.asList(o1, o2));

        return comp;
    }


}