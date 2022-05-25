package bg.tu_varna.sit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import  java.util.Date;
public class Appointment {
    //<date> <starttime> <endtime> <name> <note>
    private SimpleDateFormat sdft=new SimpleDateFormat("HH:mm");

    private GregorianCalendar date=new GregorianCalendar();
    //date.setTime()
    private Date startTime;
    private Date endTime;
    private String name;
    private String note;


    public Appointment(int day, int month, int year,String startTime,String endTime,String name,String note) throws ParseException {
        this.date=new GregorianCalendar();
        date.set(Calendar.YEAR,year);
        date.set(Calendar.MONTH,month);
        date.set(Calendar.DAY_OF_MONTH,day);
        this.startTime=new SimpleDateFormat("HH:mm").parse(startTime);
        this.endTime=new SimpleDateFormat("HH:mm").parse(endTime);
        this.name=name;
        this.note=note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "\nAppointment Name: " + name+"\n"+
                "Date: " + date.get(Calendar.DATE) +"/"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.YEAR)+
                "\nStart time: " + sdft.format(startTime) +
                "\nEnd time: " + sdft.format(endTime) +
                "\nnote: " + note +"\n"
                ;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
