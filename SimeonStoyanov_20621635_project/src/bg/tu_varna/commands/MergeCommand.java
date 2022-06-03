package bg.tu_varna.commands;

import bg.tu_varna.exceptions.FileNotOpenedException;
import bg.tu_varna.exceptions.WrongTimeException;
import bg.tu_varna.sit.Appointment;
import bg.tu_varna.sit.AppointmentsCalendar;
import bg.tu_varna.sit.DateRangeValidator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeCommand implements Command {

    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }

        JAXBContext jaxbContext = null;
        try {


            jaxbContext = JAXBContext.newInstance(AppointmentsCalendar.class);

            File file = new File("file2.xml");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            AppointmentsCalendar o = (AppointmentsCalendar) jaxbUnmarshaller.unmarshal(file);
            //OpenCommand.originalCalendarList=o.ge
           // List<Appointment>ap=AppointmentsCalendar.appointmentArrayList;
            List<Appointment>appointmentList = OpenCommand.originalCalendarList;
            AppointmentsCalendar.appointmentArrayList.addAll(appointmentList);
          /*  for (Appointment a:appointmentList) {
            for (int i=0;i<AppointmentsCalendar.appointmentArrayList.size();i++) {

                    if(a.getDate().equals(AppointmentsCalendar.appointmentArrayList.get(i).getDate())){
                        DateRangeValidator checker = new DateRangeValidator(a.getStartTime(), a.getEndTime());
                        if (((checker.isWithinRange(ap.get(i).getStartTime())) && (!checker.isWithinRange(ap.get(i).getEndTime())))
                                || ((!checker.isWithinRange(ap.get(i).getStartTime())) && (checker.isWithinRange(ap.get(i).getEndTime())))
                                || ((checker.isWithinRange(ap.get(i).getStartTime())) && (checker.isWithinRange(ap.get(i).getEndTime())))
                                || ((!checker.isWithinRange(ap.get(i).getStartTime())) && (!checker.isWithinRange(ap.get(i).getEndTime()))
                                && (ap.get(i).getStartTime().before(a.getStartTime())
                                && ap.get(i).getEndTime().after(a.getEndTime())))) {
                            Scanner scanner = new Scanner(System.in);

                            System.out.println("do you wish to change your old appointment"+AppointmentsCalendar.appointmentArrayList.get(i).toString()+"yes/no");
                            String option=scanner.nextLine();
                            if(option.equalsIgnoreCase("yes")){
                                AppointmentsCalendar.unbook(a.sdfd.format(a.getDate()),
                                       a.sdft.format(a.getStartTime()),
                                        a.sdft.format(a.getEndTime()));
                            appointmentList.add(ap.get(i));
                            break;}
                            if(option.equalsIgnoreCase("no"))
                               continue;
                        }
                    }

            }
                }*/
            AppointmentsCalendar.setAppointmentArrayList(appointmentList);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, new File("file.xml"));
            System.out.println("Calendars merged");

            jaxbContext = JAXBContext.newInstance(AppointmentsCalendar.class);

            File file1 = new File("file.xml");

            Unmarshaller jaxbUnmarshaller1 = jaxbContext.createUnmarshaller();

            AppointmentsCalendar o1 = (AppointmentsCalendar) jaxbUnmarshaller1.unmarshal(file1);
            System.out.println(o1);
            System.out.println("Calendars merged");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}