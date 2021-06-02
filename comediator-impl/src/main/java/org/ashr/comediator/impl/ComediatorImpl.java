package org.ashr.comediator.impl;

import org.ashr.comediator.api.*;

import java.util.concurrent.Future;

/** Command bus impl. */
public class ComediatorImpl implements Comediator {

    private HandlerRegistry handlerRegistry;
    private AsyncWorker asyncWorker;

    public ComediatorImpl(HandlerRegistry commandHandlerRegistry, AsyncWorker asyncWorker) {
        this.handlerRegistry = commandHandlerRegistry;
        this.asyncWorker = asyncWorker;
    }

    @Override
    public <TR> AsyncCommandTracker<TR> sendAsync(Command<TR> command) {
        CommandHandler<TR, Command<TR>> commandHandler = handlerRegistry.getCommandHandler(command);
        Future<TR> future = asyncWorker.doWork(() -> commandHandler.handle(command));
        return new AsyncOperationWrapper<>(future);
    }

    @Override
    public AsyncOperation sendAsync(Command.OneWayCommand command) {
        CommandHandler.OneWayCommandHandler oneWayCommandHandler = handlerRegistry.getOneWayCommandHandler(command);
        Future<Void> future = asyncWorker.doWork(() -> oneWayCommandHandler.handle(command));
        return new AsyncOperationWrapper<>(future);

    }

    @Override
    public <TR> TR send(Command<TR> command) {
        CommandHandler<TR, Command<TR>> commandHandler = handlerRegistry.getCommandHandler(command);
        return commandHandler.handle(command);
    }

    @Override
    public void send(Command.OneWayCommand command) {
        CommandHandler.OneWayCommandHandler oneWayCommandHandler = handlerRegistry.getOneWayCommandHandler(command);
        oneWayCommandHandler.handle(command);
    }

    @Override
    public AsyncNotificationTracker publishAsync(Notification notification) {
        Iterable<? extends NotificationHandler<? extends Notification>> notificationHandlers = handlerRegistry.getNotificationHandlers(notification);
        Future<Void> future = asyncWorker.doWork(() -> {
            for(NotificationHandler notificationHandler: notificationHandlers) {
                notificationHandler.handle(notification);
            }
            return null;
        });
        return new AsyncOperationWrapper<>(future);
    }

    @Override
    public void publish(Notification notification) {
        Iterable<? extends NotificationHandler<? extends Notification>> notificationHandlers = handlerRegistry.getNotificationHandlers(notification);
        for(NotificationHandler notificationHandler: notificationHandlers) {
            notificationHandler.handle(notification);
        }
    }
}

