package org.ashr.comediator.impl;

import org.ashr.comediator.api.Comediator;

/** ComediatorBuilder */
public class ComediatorBuilder {

    private AsyncWorker asyncWorker;
    private HandlerRegistry handlerRegistry;

    ComediatorBuilder setAsyncWorker(AsyncWorker asyncWorker) {
        this.asyncWorker = asyncWorker;
        return this;
    }

    ComediatorBuilder setHandlerRegistry(HandlerRegistry handlerRegistry) {
        this.handlerRegistry = handlerRegistry;
        return this;
    }

    Comediator build() {
        AsyncWorker asyncWorker = this.asyncWorker;
        HandlerRegistry handlerRegistry = this.handlerRegistry;
        if (asyncWorker == null) {
            asyncWorker = new DefaultAsyncWorker();
        }
        if (handlerRegistry == null) {
            handlerRegistry = new DefaultHandlerRegistry();
        }
        return new ComediatorImpl(handlerRegistry, asyncWorker);
    }
}
