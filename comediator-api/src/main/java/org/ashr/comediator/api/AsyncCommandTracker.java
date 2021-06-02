package org.ashr.comediator.api;

public interface AsyncCommandTracker<TR> extends AsyncOperation {

    /**
     * Wait while async operation has done and get result
     * @return
     */
    TR await();

}
