package org.ashr.comediator.impl;

import org.ashr.comediator.api.CommandHandler;

import java.util.concurrent.TimeUnit;

public class LongComandHandler implements CommandHandler.OneWayCommandHandler<LongCommand> {
    @Override
    public void handleOneWay(LongCommand command) {
        for(int i = 0; i < 1000; i++) {
            System.out.println("Hello " + i + "   " + command.word);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
