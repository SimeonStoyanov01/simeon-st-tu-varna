package bg.tu_varna.commands;

import bg.tu_varna.sit.FileNotOpenedException;

import java.text.ParseException;

public interface Command {
    void execute(Object[] args) throws ParseException, FileNotOpenedException;
}