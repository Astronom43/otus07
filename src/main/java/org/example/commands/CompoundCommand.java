package org.example.commands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Класс, отрабатывающий логику выполнения команд в порядке поступления
 */
public class CompoundCommand{
    private final Queue<Command> commands = new LinkedList<>();
    private final ExceptionHandler exceptionHandler;

    public CompoundCommand(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public void execution(){
        while (!commands.isEmpty()){
            final Command command = commands.poll();
            try {
                if (command != null){
                    command.execute();
                }
            } catch (Exception e){
                final Command except = exceptionHandler.except(command, e);
                if (except != null){
                    addCommand(except);
                }
            }
        }
    }

    public void addCommand(Command command){
        commands.offer(command);
    }
}