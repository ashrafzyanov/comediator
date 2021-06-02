package org.ashr.comediator.impl;

import org.junit.jupiter.api.Test;
import org.ashr.comediator.api.AsyncOperation;
import org.ashr.comediator.api.Comediator;

import java.util.concurrent.TimeUnit;

class CommandBusTest {

    @Test
    void test1() {
        DefaultHandlerRegistry defaultHandlerRegistry = new DefaultHandlerRegistry();
        AsyncWorker asyncWorker = new DefaultAsyncWorker();
        Comediator comediator = new ComediatorImpl(defaultHandlerRegistry, asyncWorker);
        defaultHandlerRegistry.add(Commands.StringCommand.class, new Commands.StringCommandHandler());
        defaultHandlerRegistry.add(Commands.IntegerCommand.class, new Commands.IntegerCommandHandler());
        defaultHandlerRegistry.add(LongCommand.class, new LongComandHandler());

        String result = comediator.send(new Commands.StringCommand("Nick"));
        Integer resultInt = comediator.send(new Commands.IntegerCommand(10));
        AsyncOperation asyncOperation = comediator.sendAsync(new LongCommand("Tester"));

        System.out.println(result);
        System.out.println(resultInt);

        while (!asyncOperation.isDone()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
