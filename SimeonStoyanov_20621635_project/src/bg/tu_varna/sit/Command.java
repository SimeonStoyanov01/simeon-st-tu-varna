package bg.tu_varna.sit;

import java.text.ParseException;

public interface Command {
    void execute(Object[] args) throws ParseException;
}