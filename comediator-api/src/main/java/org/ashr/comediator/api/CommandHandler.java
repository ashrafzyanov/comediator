package org.ashr.comediator.api;

/**
 * Command handler.
 *
 * @param <TR> type of result of handler
 * @param <TC> type of command to handle
 */
public interface CommandHandler<TR, TC extends Command<TR>> extends BaseCommandHandler {

    /**
     * Handle command
     *
     * @param command
     * @return result of handler
     */
    TR handle(TC command);

    /**
     * One way command handler.
     * @param <TC> type of command
     */
    interface OneWayCommandHandler<TC extends Command.OneWayCommand> extends CommandHandler<Void, TC> {

         @Override
         default Void handle(TC command) {
             handleOneWay(command);
             return null;
         }

         void handleOneWay(TC command);
     }

}