package org.b3log.reactor;


import org.springframework.stereotype.Service;

/**
 * @author : yu.zhang
 * Date : 2018/6/11 下午5:09
 * Email : yu.zhang@7fresh.com
 **/
@Service
public class NotificationServiceimpl implements NotificationService {

    @Override
    public void initiateNotification(NotificationData notificationData)
            throws InterruptedException {

        System.out.println("Notification service started for "
                + "Notification ID: " + notificationData.getId());

        Thread.sleep(5000);

        System.out.println("Notification service ended for "
                + "Notification ID: " + notificationData.getId());
    }
}
