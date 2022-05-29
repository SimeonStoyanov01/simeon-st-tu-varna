package bg.tu_varna.sit;

import bg.tu_varna.exceptions.WrongTimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"appointmentArrayList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class AppointmentsCalendar {
    @XmlElement(name = "appointment")
    public static List<Appointment> appointmentArrayList=new ArrayList<>();


    @Override
    public String toString() {
                 String listString = appointmentArrayList.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
                 return listString;
    }
    public static void all(){

        for (Appointment a:appointmentArrayList
             ) {
            System.out.println(a);

        }
    }


    public AppointmentsCalendar(ArrayList<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
    }
    public AppointmentsCalendar() {

    }
    //public AppointmentsCalendar(){}
    public static List<Appointment> addToCollection(Appointment appointment) throws WrongTimeException {
        //for (int i=0;i<appointmentArrayList.size();i++) {
            /*if(appointment.getDate().equals(a.getDate())
                    &&((appointment.getStartTime().after(a.getStartTime())
                    ||appointment.getStartTime().equals(a.getStartTime())))){}*/
           //DateRangeValidator checker=new DateRangeValidator(appointmentArrayList.get(i).getStartTime(),appointmentArrayList.get(i).getEndTime());
           // if(appointment.getDate().equals(appointmentArrayList.get(i).getDate())&&(appointment.getStartTime().after(appointment.getEndTime())||checker.isWithinRange(appointment.getStartTime())
              //      ||checker.isWithinRange(appointment.getEndTime()))){
               // throw new WrongTimeException();
          //  }
           // else {
        //for (Appointment a:appointmentArrayList) {


                appointmentArrayList.add(appointment);
                System.out.println("Booking added successfully");//}

        //}


            return appointmentArrayList;

    }
    public static void unbook(String date, String startTime, String endTime){

        for(int i=0;i<appointmentArrayList.size();i++){
            if((date.equals(appointmentArrayList.get(i).sdfd.format(appointmentArrayList.get(i).getDate())))
                    &&(startTime.equals(appointmentArrayList.get(i).sdft.format(appointmentArrayList.get(i).getStartTime())))
            &&endTime.equals(appointmentArrayList.get(i).sdft.format(appointmentArrayList.get(i).getEndTime()))){
                appointmentArrayList.remove(appointmentArrayList.get(i));
            }
            else System.out.println("No such appointment exists\n");
        }


    }
    public static void agenda(String date){
        ArrayList<Appointment>appointmentArrayList1=new ArrayList<>();
        for (Appointment a:appointmentArrayList) {
            if(date.equals(a.sdfd.format(a.getDate()))){

                appointmentArrayList1.add(a); }}
                Collections.sort(appointmentArrayList1, new Comparator<Appointment>() {
                    public int compare(Appointment a1, Appointment a2) {
                        return a1.getStartTime().compareTo(a2.getStartTime());
                    }
                });
                for (Appointment a1:appointmentArrayList1) {
                    System.out.println(a1);
                }
                appointmentArrayList1.clear();



    }
    public static void find(String occurrence){
        for (Appointment a:appointmentArrayList) {
            if(occurrence.equalsIgnoreCase(a.getNote())||occurrence.equalsIgnoreCase(a.getName())){
                System.out.println(a);
            }

        }
    }
    public static void holiday(String date){

    }
    public static void change(String date,String startTime,String option,String newValue) throws ParseException {
        for (int i=0;i<appointmentArrayList.size();i++) {
            if(date.equals(appointmentArrayList.get(i).sdfd.format(appointmentArrayList.get(i).getDate()))
                    &&startTime.equals(appointmentArrayList.get(i).sdft.format(appointmentArrayList.get(i).getStartTime()))){
                if(option.equalsIgnoreCase("date")){
                appointmentArrayList.get(i).setDate(new SimpleDateFormat("dd/MM/yyyy").parse(newValue));}
                if(option.equalsIgnoreCase("starttime")){
                appointmentArrayList.get(i).setStartTime(new SimpleDateFormat("HH:mm").parse(newValue));}
                if(option.equalsIgnoreCase("endtime")){
                    appointmentArrayList.get(i).setEndTime(new SimpleDateFormat("HH:mm").parse(newValue));}
                if(option.equalsIgnoreCase("note")){
                    appointmentArrayList.get(i).setNote(newValue);}
                if(option.equalsIgnoreCase("name")){
                    appointmentArrayList.get(i).setName(newValue);}
                else
                    System.out.println("Wrong parameter!");
            }

        }
    }



    public static List<Appointment> getAppointmentArrayList() {
        return appointmentArrayList;
    }

    public void setAppointmentArrayList(List<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
    }
    public static AppointmentsCalendar calendarInstance=new AppointmentsCalendar();
    public static AppointmentsCalendar getCalendarInstance(){
        return calendarInstance;
    }
    public static void setCalendarInstance(AppointmentsCalendar appointmentsCalendar){
        calendarInstance=appointmentsCalendar;
    }
}
