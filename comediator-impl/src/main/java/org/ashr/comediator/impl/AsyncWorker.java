package org.ashr.comediator.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/** Run work in async mode */
public interface AsyncWorker {

    /**
     * Run async work
     *
     * @param task work
     * @param <TR> type of result
     * @return tracker of future result
     */
    <TR> Future<TR> doWork(Callable<TR> task);
}
