package org.example.commands;

/**
 * Класс, отрабатывающий кейс второго повторного исполнения команды после выброса исключения
 */
public class BiRepeatCommand implements Command{
    private final Command command;


    public BiRepeatCommand(Object[] command) {
        this.command = (Command) command[0];
    }

    @Override
    public void execute() {
        command.execute();
    }
}