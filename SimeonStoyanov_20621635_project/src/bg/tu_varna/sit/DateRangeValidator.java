package bg.tu_varna.sit;

import java.util.Date;

public class DateRangeValidator {

    private final Date startTime;
    private final Date endTime;

    public DateRangeValidator(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public boolean isWithinRange(Date testDate) {

        // it works, alternatives
        boolean result = false;
        if ((testDate.equals(startTime) || testDate.equals(endTime)) ||
                (testDate.after(startTime) && testDate.before(endTime))) {
            result = true;
        }
        return result;


    }

}

