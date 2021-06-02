package org.ashr.comediator.api;

/**
 * Command to execute. It can be request (have return result) or command.
 * @param <TR> type of response
 */
public interface Command<TR> extends BaseCommand {

    /** Fire and forgot command. Without response. */
    interface OneWayCommand extends Command<Void> {}

}