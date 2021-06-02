package org.ashr.comediator.api.ex;

import org.ashr.comediator.api.BaseCommand;

/** Throw when command handler is not found. */
public class CommandHandlerNotFoundException extends ComediatorException {

    private BaseCommand command;

    public CommandHandlerNotFoundException(final BaseCommand command) {
        this.command = command;
    }

    public BaseCommand getCommand() {
        return command;
    }

}
