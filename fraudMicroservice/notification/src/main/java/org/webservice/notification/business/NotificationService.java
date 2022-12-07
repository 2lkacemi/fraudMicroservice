package org.webservice.notification.business;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webservice.clients.notification.NotificationRequest;
import org.webservice.notification.persistence.Notification;
import org.webservice.notification.persistence.NotificationRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("anas")
                        .message(notificationRequest.message())
                        .sendAt(LocalDateTime.now())
                        .build()
        );


    }


}
