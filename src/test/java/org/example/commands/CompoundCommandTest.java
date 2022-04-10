package org.example.commands;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class CompoundCommandTest {


    GreetingCommand testCommand = Mockito.mock(GreetingCommand.class);
    ExceptionHandler handler = new ExceptionHandler();
    CompoundCommand command = Mockito.spy(new CompoundCommand(handler));

    @Test
    void testCaseNumberOne() {
        Mockito.doThrow(IllegalArgumentException.class).when(testCommand).execute();
        command.addCommand(testCommand);
        command.execution();
        final InOrder inOrder = Mockito.inOrder(command);
        inOrder.verify(command, Mockito.times(1)).addCommand(Mockito.any(RepeatCommand.class));
        inOrder.verify(command, Mockito.times(1)).addCommand(Mockito.any(LogExceptionCommand.class));
    }

    @Test
    void tesCaseNumberTwo(){
        Mockito.doThrow(NullPointerException.class).when(testCommand).execute();
        command.addCommand(testCommand);
        command.execution();
        final InOrder inOrder = Mockito.inOrder(command);
        inOrder.verify(command, Mockito.times(1)).addCommand(Mockito.any(RepeatCommand.class));
        inOrder.verify(command, Mockito.times(1)).addCommand(Mockito.any(BiRepeatCommand.class));
        inOrder.verify(command, Mockito.times(1)).addCommand(Mockito.any(LogExceptionCommand.class));
    }
}