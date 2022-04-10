package org.example.commands;
/**
 * Класс, отрабатывающий кейс повторного исполнения команды после выброса исключения
 */
public class RepeatCommand implements Command{
    private final Command command;

    public RepeatCommand(Object[] command) {
        this.command = (Command) command[0];
    }

    @Override
    public void execute() {
        command.execute();
    }
}
