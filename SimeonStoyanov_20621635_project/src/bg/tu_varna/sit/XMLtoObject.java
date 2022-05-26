package bg.tu_varna.sit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
public class XMLtoObject{
    public static AppointmentsCalendar xmlTOObject(String fileName) throws JAXBException, IOException{
        JAXBContext context=JAXBContext.newInstance(AppointmentsCalendar.class);
                return (AppointmentsCalendar)
                        context.createUnmarshaller()
                                .unmarshal((new FileReader("file.xml")));
    }
}
*/