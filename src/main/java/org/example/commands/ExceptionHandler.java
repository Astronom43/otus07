package org.example.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Класс, отрабатывающий логику обработки ошибок
 */
public class ExceptionHandler{

    private final Map<String, Function<Object[],Command>> commandStore;

    public ExceptionHandler() {
        commandStore = new HashMap<>();
        commandStore.put(RepeatCommand.class.getName() + IllegalArgumentException.class.getName(), LogExceptionCommand::new);
        commandStore.put(GreetingCommand.class.getName() + IllegalArgumentException.class.getName(), RepeatCommand::new);
        commandStore.put(GreetingCommand.class.getName() + NullPointerException.class.getName(), RepeatCommand::new);
        commandStore.put(RepeatCommand.class.getName() + NullPointerException.class.getName(), BiRepeatCommand::new);
        commandStore.put(BiRepeatCommand.class.getName() + NullPointerException.class.getName(), LogExceptionCommand::new);
    }

    public Command except(Command command, Exception e){
        final String key = command.getClass().getName() + e.getClass().getName();
        return commandStore.get(key).apply(new Object[]{command, e});
    }
}
