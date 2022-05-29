package bg.tu_varna.sit;

import java.util.Date;

public class DateRangeValidator {

    private final Date startTime;
    private final Date endTime;

    public DateRangeValidator(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // inclusive startDate and endDate
    // the equals ensure the inclusive of startDate and endDate,
    // if prefer exclusive, just delete the equals
    public boolean isWithinRange(Date testDate) {

        // it works, alternatives
        boolean result = false;
        if ((testDate.equals(startTime) || testDate.equals(endTime)) ||
                (testDate.after(startTime) && testDate.before(endTime))) {
            result = true;
        }
        return result;

        // compare date and time, inclusive of startDate and endDate
        // getTime() returns number of milliseconds since January 1, 1970, 00:00:00 GMT
       // return testDate.getTime() >= startTime.getTime() &&
               // testDate.getTime() <= endTime.getTime();
    }

}

