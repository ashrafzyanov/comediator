package org.ashr.comediator.impl;

import org.ashr.comediator.api.Command;
import org.ashr.comediator.api.CommandHandler;
import org.ashr.comediator.api.Notification;
import org.ashr.comediator.api.NotificationHandler;

/** Registry of available command handler */
public interface HandlerRegistry {

    /**
     * Get handler by command type
     *
     * @param commandClass description of command type
     * @return handler of command
     */
    <TR> CommandHandler<TR, Command<TR>> getCommandHandler(Command<TR> commandClass);

    /**
     * Get handler by command type
     *
     * @param command
     * @return
     */
    CommandHandler.OneWayCommandHandler<Command.OneWayCommand> getOneWayCommandHandler(Command.OneWayCommand command);

    /**
     * Get notification handlers
     *
     * @param notification
     * @return
     */
    Iterable<NotificationHandler<Notification>> getNotificationHandlers(Notification notification);

}
