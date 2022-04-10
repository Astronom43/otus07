package org.example.commands;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс, отрабатывающий кейс вывода исключения в лог
 */
public class LogExceptionCommand implements Command {
    private static Logger log = LogManager.getLogger(LogExceptionCommand.class);
    private final Exception exception;

    public LogExceptionCommand(Object[] args) {
        this.exception = (Exception) args[1];
    }

    @Override
    public void execute() {
        log.error(exception);
    }
}