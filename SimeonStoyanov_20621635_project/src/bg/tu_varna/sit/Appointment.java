package bg.tu_varna.sit;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import  java.util.Date;


@XmlRootElement
@XmlType(propOrder = {"name", "note","date","startTime","endTime"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment {
    //<date> <starttime> <endtime> <name> <note>
    @XmlTransient
    public SimpleDateFormat sdft=new SimpleDateFormat("HH:mm");
    @XmlTransient
    public SimpleDateFormat sdfd=new SimpleDateFormat("dd/MM/yyyy");
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;//=new GregorianCalendar();

    @XmlJavaTypeAdapter(TimeOfDayAdapter.class)
    private Date startTime;
    @XmlJavaTypeAdapter(TimeOfDayAdapter.class)
    private Date endTime;
    @XmlAttribute
    private String name;

    private String note;


    public Appointment(String date,String startTime,String endTime,String name,String note) throws ParseException {
        this.date=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        //date.set(Calendar.YEAR,year);
        //date.set(Calendar.MONTH,month);
        //date.set(Calendar.DAY_OF_MONTH,day);
        this.startTime=new SimpleDateFormat("HH:mm").parse(startTime);
        this.endTime=new SimpleDateFormat("HH:mm").parse(endTime);
        this.name=name;
        this.note=note;
    }

    public Appointment() {
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
                "Date: " + sdfd.format(date)+
                "\nStart time: " + sdft.format(startTime) +
                "\nEnd time: " + sdft.format(endTime) +
                "\nnote: " + note +"\n"
                ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
