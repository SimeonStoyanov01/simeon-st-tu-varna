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
            List<Appointment>appointmentList = OpenCommand.originalCalendarList;
            /*for (int i=0;i<AppointmentsCalendar.appointmentArrayList.size();i++) {
                    if(a.getDate().equals(AppointmentsCalendar.appointmentArrayList.get(i).getDate())){
                        DateRangeValidator checker = new DateRangeValidator(AppointmentsCalendar.appointmentArrayList.get(i).getStartTime(), AppointmentsCalendar.appointmentArrayList.get(i).getEndTime());
                        if (((checker.isWithinRange(a.getStartTime())) && (!checker.isWithinRange(a.getEndTime())))
                                || ((!checker.isWithinRange(a.getStartTime())) && (checker.isWithinRange(a.getEndTime())))
                                || ((checker.isWithinRange(a.getStartTime())) && (checker.isWithinRange(a.getEndTime())))
                                || ((!checker.isWithinRange(a.getStartTime())) && (!checker.isWithinRange(a.getEndTime()))
                                && (a.getStartTime().before(AppointmentsCalendar.appointmentArrayList.get(i).getStartTime())
                                && a.getEndTime().after(AppointmentsCalendar.appointmentArrayList.get(i).getEndTime())))) {
                            Scanner scanner = new Scanner(System.in);

                            System.out.println("do you wish to change your old appointment"+AppointmentsCalendar.appointmentArrayList.get(i).toString()+"yes/no");
                            String option=scanner.nextLine();
                            if(option.equalsIgnoreCase("yes")){
                                AppointmentsCalendar.unbook(AppointmentsCalendar.appointmentArrayList.get(i).sdfd.format(AppointmentsCalendar.appointmentArrayList.get(i).getDate()),
                                        AppointmentsCalendar.appointmentArrayList.get(i).sdft.format(AppointmentsCalendar.appointmentArrayList.get(i).getStartTime()),
                                        AppointmentsCalendar.appointmentArrayList.get(i).sdft.format(AppointmentsCalendar.appointmentArrayList.get(i).getEndTime()));
                            AppointmentsCalendar.appointmentArrayList.add(a);
                            break;}
                            if(option.equalsIgnoreCase("no"))
                               continue;
                        }
                    }
                    else

                }*/
            AppointmentsCalendar.appointmentArrayList.addAll(appointmentList);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, new File("file.xml"));
            System.out.println("Calendars merged");
            jaxbMarshaller.marshal(o, System.out);
            System.out.println("Calendars merged");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}