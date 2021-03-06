package bg.tu_varna.commands;

import bg.tu_varna.exceptions.FileNotOpenedException;
import bg.tu_varna.exceptions.HolidayException;

import java.text.ParseException;

public interface Command {
    void execute(Object[] args) throws ParseException, FileNotOpenedException, HolidayException;
}