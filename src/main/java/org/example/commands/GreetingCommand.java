package org.example.commands;

/**
 * Начальная команда,
 */
public class GreetingCommand implements Command {

    @Override
    public void execute() {
        System.out.printf("Hello World!");
    }
}
