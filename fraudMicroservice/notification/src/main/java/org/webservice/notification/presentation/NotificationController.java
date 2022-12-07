package org.webservice.notification.presentation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.clients.notification.NotificationRequest;
import org.webservice.notification.business.NotificationService;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New notification...{}", notificationRequest);
        notificationService.send(notificationRequest);
    }

}