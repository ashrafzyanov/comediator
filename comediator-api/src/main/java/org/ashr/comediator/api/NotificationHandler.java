package org.ashr.comediator.api;

/**
 * Notification handle
 * @param <TN> type of notification
 */
public interface NotificationHandler<TN extends Notification> {

    void handle(TN notification);

}
