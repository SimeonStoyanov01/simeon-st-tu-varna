package bg.tu_varna.sit;
/*
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.util.ArrayList;
public class ObjectToXML {
    public static void objectToXML(AppointmentsCalendar appointmentsCalendar,String fileName) throws Exception{
        JAXBContext contextObj = JAXBContext.newInstance(AppointmentsCalendar.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Answer ans1=new Answer(101,"java is a programming language","ravi");
        //Answer ans2=new Answer(102,"java is a platform","john");

        // ArrayList<Answer> list=new ArrayList<Answer>();
        // list.add(ans1);
        //list.add(ans2);

        // Question que=new Question(1,"What is java?",list);
        marshallerObj.marshal(appointmentsCalendar, new FileOutputStream("file.xml"));

    }
}*/