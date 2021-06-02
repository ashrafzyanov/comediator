package org.ashr.comediator.api;

/** Send notification to handle by multiple handler */
public interface NotificationPublisher {

    /**
     * Send async notification
     * @param notification
     * @return
     */
    AsyncNotificationTracker publishAsync(Notification notification);

    /**
     * Send sync notification
     * @param notification
     */
    void publish(Notification notification);

}
