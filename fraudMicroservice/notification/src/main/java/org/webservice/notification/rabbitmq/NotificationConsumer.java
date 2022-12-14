package org.webservice.notification.rabbitmq;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.webservice.clients.notification.NotificationRequest;
import org.webservice.notification.business.NotificationService;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumer {} from queue", notificationRequest);
        notificationService.send(notificationRequest);

    }
}
