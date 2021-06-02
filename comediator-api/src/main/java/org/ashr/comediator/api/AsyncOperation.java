package org.ashr.comediator.api;

/**
 * Present tracker of async operation.
 */
public interface AsyncOperation {

    /**
     * Just wait and ignore return value if any
     */
    void justAwait();

    /**
     * Check that async operation is done
     * @return
     */
    boolean isDone();

    /**
     * Try to cancel async operation
     */
    void cancel();

    /**
     * Check that async operation was canceled
     * @return
     */
    boolean isCanceled();

}
