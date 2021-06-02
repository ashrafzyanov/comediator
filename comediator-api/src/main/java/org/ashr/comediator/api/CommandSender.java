package org.ashr.comediator.api;

/** Send command to dispatch by one handler. */
public interface CommandSender {

    /**
     * Async send command to execute by one handler
     *
     * @param command action to execute
     * @param <TR> type of return
     * @return
     */
    <TR> AsyncCommandTracker<TR> sendAsync(Command<TR> command);

    /**
     * Async send command to execute by one handler without result
     * @param command
     * @return
     */
    AsyncOperation sendAsync(Command.OneWayCommand command);

    /**
     * Sync send command to execute by one handler
     * @param command
     * @param <TR>
     * @return
     */
    <TR> TR send(Command<TR> command);

    /**
     * Send command to execute by one handler without result
     * @param command
     */
    void send(Command.OneWayCommand command);

}
