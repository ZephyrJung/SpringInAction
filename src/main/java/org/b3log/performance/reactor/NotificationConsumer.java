package org.b3log.performance.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;


/**
 * @author : yu.zhang
 * Date : 2018/6/11 下午5:09
 * Email : zephyrjung@126.com
 **/
@Service
public class NotificationConsumer implements
        Consumer<Event<NotificationData>> {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {
        NotificationData notificationData = notificationDataEvent.getData();

        try {
            notificationService.initiateNotification(notificationData);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
