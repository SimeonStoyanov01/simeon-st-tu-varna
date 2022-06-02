package bg.tu_varna.sit;

public class DayTime implements Comparable<DayTime> {
    String weekday;
    Long timeBooked;
    public DayTime(String weekday,Long timeBooked){
        this.timeBooked=timeBooked;
        this.weekday=weekday;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Long getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(Long timeBooked) {
        this.timeBooked = timeBooked;
    }

    @Override
    public String toString() {
        return  weekday + ":\t" +
                 timeBooked
                ;
    }

    @Override
    public int compareTo(DayTime o) {
        return getTimeBooked().compareTo(o.getTimeBooked());
    }
}
