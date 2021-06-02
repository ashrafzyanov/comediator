package org.ashr.comediator.impl;

import org.ashr.comediator.api.Command;
import org.ashr.comediator.api.CommandHandler;
import org.ashr.comediator.api.Notification;
import org.ashr.comediator.api.NotificationHandler;
import org.ashr.comediator.api.ex.CommandHandlerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultHandlerRegistry implements HandlerRegistry {

    private Map map = new ConcurrentHashMap();
    private Map notificationMap = new ConcurrentHashMap();

    public <TR> void add(Class<? extends Command<TR>> commandClass, CommandHandler<TR, ? extends Command<TR>> commandHandler) {
        map.put(commandClass, commandHandler);
    }

    public void addNotification(Class<Notification> notificationClass, NotificationHandler<Notification> notificationHandler) {
        List<NotificationHandler<Notification>> notificationHandlers = (List<NotificationHandler<Notification>>) notificationMap.get(notificationClass);
        if (notificationHandlers == null) {
            notificationHandlers = new ArrayList<>();
            notificationMap.put(notificationClass, notificationHandlers);
        }
        notificationHandlers.add(notificationHandler);
    }

    @Override
    public <TR> CommandHandler<TR, Command<TR>> getCommandHandler(Command<TR> commandClass) {
        CommandHandler commandHandler = (CommandHandler) map.get(commandClass.getClass());
        if (commandHandler == null) {
            throw new CommandHandlerNotFoundException(commandClass);
        }
        return commandHandler;
    }

    @Override
    public CommandHandler.OneWayCommandHandler<Command.OneWayCommand> getOneWayCommandHandler(Command.OneWayCommand command) {
        CommandHandler commandHandler = (CommandHandler) map.get(command.getClass());
        if (commandHandler == null) {
            throw new CommandHandlerNotFoundException(command);
        }
        return (CommandHandler.OneWayCommandHandler<Command.OneWayCommand>) commandHandler;
    }

    @Override
    public Iterable<NotificationHandler<Notification>> getNotificationHandlers(Notification notification) {
        return null;
    }
}
