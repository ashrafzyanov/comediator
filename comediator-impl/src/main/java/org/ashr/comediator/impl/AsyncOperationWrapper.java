package org.ashr.comediator.impl;

import org.ashr.comediator.api.AsyncCommandTracker;
import org.ashr.comediator.api.AsyncNotificationTracker;
import org.ashr.comediator.api.AsyncOperation;
import org.ashr.comediator.api.ex.AsyncComediatorException;
import org.ashr.comediator.api.ex.AsyncOperationCancelException;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** Wrapper to Async operation. */
public class AsyncOperationWrapper<TR> implements AsyncOperation, AsyncCommandTracker<TR>, AsyncNotificationTracker {

    protected Future<TR> future;

    public AsyncOperationWrapper(Future<TR> future) {
        this.future = future;
    }

    @Override
    public void justAwait() {
        try {
            future.get();
        } catch (CancellationException ex) {
            throw new AsyncOperationCancelException();
        } catch (InterruptedException e) {
            throw new AsyncComediatorException();
        } catch (ExecutionException e) {
            throw new AsyncComediatorException();
        }
    }

    @Override
    public TR await() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            throw new AsyncComediatorException();
        } catch (ExecutionException e) {
            throw new AsyncComediatorException();
        }
    }

    @Override
    public boolean isDone() {
        return future.isDone();
    }

    @Override
    public void cancel() {
        future.cancel(true);
    }

    @Override
    public boolean isCanceled() {
        return future.isCancelled();
    }

}
