package org.ashr.comediator.impl;

import java.util.concurrent.*;

/** Default implementation. */
public class DefaultAsyncWorker implements AsyncWorker {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public <TR> Future<TR> doWork(Callable<TR> task) {
        return executorService.submit(task);
    }

}
