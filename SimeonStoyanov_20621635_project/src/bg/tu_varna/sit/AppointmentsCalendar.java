package bg.tu_varna.sit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        /*StringBuilder sb = new StringBuilder();
        for (Appointment s : appointmentArrayList)
        {
            sb.append(s);
            sb.append("\n");
        }

        System.out.println(sb.toString());*/
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
    public static List<Appointment> addToCollection(Appointment appointment){

            appointmentArrayList.add(appointment);
            return appointmentArrayList;

    }
    public static void unbook(String date, String startTime, String endTime){
        for (Appointment a:appointmentArrayList) {
            if(date.equals(a.sdfd.format(a.getDate()))&&startTime.equals(a.sdft.format(a.getStartTime()))
                    &&endTime.equals(a.sdft.format(a.getEndTime()))){
                appointmentArrayList.remove(a);
            }
            else System.out.println("No such appointment exists\n");
        }

    }

    public List<Appointment> getAppointmentArrayList() {
        return appointmentArrayList;
    }

    public void setAppointmentArrayList(List<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
    }
}
