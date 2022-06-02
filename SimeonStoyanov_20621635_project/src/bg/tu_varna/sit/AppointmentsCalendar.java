package bg.tu_varna.sit;

import bg.tu_varna.exceptions.EndBeforeStartException;
import bg.tu_varna.exceptions.EndBeforeStartException2;
import bg.tu_varna.exceptions.HolidayException;
import bg.tu_varna.exceptions.WrongTimeException;
import com.sun.org.apache.xpath.internal.operations.Variable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"appointmentArrayList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class AppointmentsCalendar {
    @XmlElement(name = "appointment")
    public static List<Appointment> appointmentArrayList=new ArrayList<>();



    @XmlTransient
    public static ArrayList<Date>dateArrayList=new ArrayList<>();


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
    public static List<Appointment> addToCollection(Appointment appointment) throws WrongTimeException, EndBeforeStartException, HolidayException {
        if(AppointmentsCalendar.dateArrayList.contains(appointment.getDate()))
            throw new HolidayException();
        if(appointment.getEndTime().before(appointment.getStartTime())){
            throw new EndBeforeStartException();
        }
        for (int i=0;i<appointmentArrayList.size();i++) {
            if(appointment.getDate().equals(appointmentArrayList.get(i).getDate())){
                DateRangeValidator checker = new DateRangeValidator(appointmentArrayList.get(i).getStartTime(), appointmentArrayList.get(i).getEndTime());
                if (((checker.isWithinRange(appointment.getStartTime())) && (!checker.isWithinRange(appointment.getEndTime())))
                        || ((!checker.isWithinRange(appointment.getStartTime())) && (checker.isWithinRange(appointment.getEndTime())))
                        || ((checker.isWithinRange(appointment.getStartTime())) && (checker.isWithinRange(appointment.getEndTime())))
                        || ((!checker.isWithinRange(appointment.getStartTime())) && (!checker.isWithinRange(appointment.getEndTime()))
                        && (appointment.getStartTime().before(appointmentArrayList.get(i).getStartTime()) && appointment.getEndTime().after(appointmentArrayList.get(i).getEndTime())))) {
                    throw new WrongTimeException();
                }
            }
            }
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
    public static void holiday(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        dateArrayList.add(date1);
    }
    public static void change(String date,String startTime,String option,String newValue) throws ParseException, EndBeforeStartException, WrongTimeException {
        Date sdft=new SimpleDateFormat("HH:mm").parse(newValue);
        Date sdfd=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        for (int i=0;i<appointmentArrayList.size();i++) {
            if(date.equals(appointmentArrayList.get(i).sdfd.format(appointmentArrayList.get(i).getDate()))
                    &&startTime.equals(appointmentArrayList.get(i).sdft.format(appointmentArrayList.get(i).getStartTime()))){
                if(option.equalsIgnoreCase("date")){
                    appointmentArrayList.get(i).setDate(new SimpleDateFormat("dd/MM/yyyy").parse(newValue));}
                if(option.equalsIgnoreCase("starttime")){
                    if(appointmentArrayList.get(i).getEndTime().before(sdft)){
                        throw new EndBeforeStartException();
                    }
                   // if(sdfd.equals(appointmentArrayList.get(i).getDate())){
                    /*DateRangeValidator checker = new DateRangeValidator(appointmentArrayList.get(i).getStartTime(), appointmentArrayList.get(i).getEndTime());
                    if (checker.isWithinRange(sdft)&&sdfd.equals(appointmentArrayList.get(i).getDate()))/* && (!checker.isWithinRange(appointmentArrayList.getEndTime())))
                            || ((!checker.isWithinRange(sdft)) && (checker.isWithinRange(appointmentArrayList.getEndTime())))
                            || ((checker.isWithinRange(sdft)) && (checker.isWithinRange(appointmentArrayList.getEndTime())))
                            || ((!checker.isWithinRange(sdft)) && (!checker.isWithinRange(appointmentArrayList.getEndTime()))
                            && (sdft.before(appointmentArrayList.get(i).getStartTime()) && appointmentArrayList.getEndTime().after(appointmentArrayList.get(i).getEndTime())))) {
                        throw new WrongTimeException();
                    }*/

                    appointmentArrayList.get(i).setStartTime(new SimpleDateFormat("HH:mm").parse(newValue));}
                if(option.equalsIgnoreCase("endtime")){
                    if(appointmentArrayList.get(i).getStartTime().after(sdft)){
                        throw new EndBeforeStartException();
                    }
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
    public static void busyDays(String from,String to) throws ParseException, EndBeforeStartException2 {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(from);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(to);
        if(date1.after(date2)){
            throw new EndBeforeStartException2();
        }
        DateFormat date3=new SimpleDateFormat("EEEE",Locale.ENGLISH);
        ArrayList<Appointment>appointmentArrayList1=new ArrayList<>();
        //public static Long mon=0;
        ArrayList<DayTime> dayTimeArrayList=new ArrayList<>();

        long mon=0,tue=0,wed=0,th=0,fri=0,sat=0,sun=0;long minutes;

        //long []array={mon,tue,wed,th,fri,sat,sun};
        for (Appointment a:appointmentArrayList) {
            if((a.getDate().equals(date1)||a.getDate().after(date1))&&(a.getDate().equals(date2)||a.getDate().before(date2))){
                appointmentArrayList1.add(a);
            }
        }
        for (Appointment a1:appointmentArrayList1) {

            if(date3.format(a1.getDate()).equalsIgnoreCase("monday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                mon += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("tuesday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                tue += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("wednesday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                wed += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("thursday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                th += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("friday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                fri += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("saturday")){
                minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
                sat += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
            if(date3.format(a1.getDate()).equalsIgnoreCase("sunday")){
            minutes=a1.getEndTime().getTime()-a1.getStartTime().getTime();
            sun += TimeUnit.MILLISECONDS.toMinutes(minutes);
            }
        }

        dayTimeArrayList.add(new DayTime("Monday",mon));
        dayTimeArrayList.add(new DayTime("Tuesday",tue));
        dayTimeArrayList.add(new DayTime("Wednesday",wed));
        dayTimeArrayList.add(new DayTime("Thursday",th));
        dayTimeArrayList.add(new DayTime("Friday",fri));
        dayTimeArrayList.add(new DayTime("Saturday",sat));
        dayTimeArrayList.add(new DayTime("Sunday",sun));
        Collections.sort(dayTimeArrayList, new Comparator<DayTime>() {
            public int compare(DayTime a1, DayTime a2) {
                return a2.getTimeBooked().compareTo(a1.getTimeBooked());
            }
        });
        for (DayTime a1:dayTimeArrayList) {
            if(a1.getTimeBooked()!=0){
                int hours=a1.getTimeBooked().intValue()/60;
                int minutes1=a1.getTimeBooked().intValue()%60;
                System.out.println(a1.getWeekday()+"\t");
                System.out.printf("%d:%02d", hours, minutes1);
                System.out.println();
            }

        }

    }
    public static void findSlot(String date,int hours) throws ParseException {
        Appointment appointment=new Appointment();
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        //for(int i=0;i<appointmentArrayList.size();i++){
        //if(appointmentArrayList.get(i).getDate().after(date1)
            //    &&appointmentArrayList.get(i).getStartTime().after(new SimpleDateFormat("HH:mm").parse("08:00"))
          //      &&appointmentArrayList.get(i).getEndTime().before(new SimpleDateFormat("HH:mm").parse("17:00"))){
        //}
        //}
        appointment.getDate().after(date1);
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
    public static ArrayList<Date> getDateArrayList() {
        return dateArrayList;
    }

    public static void setDateArrayList(ArrayList<Date> dateArrayList) {
        AppointmentsCalendar.dateArrayList = dateArrayList;
    }
}
