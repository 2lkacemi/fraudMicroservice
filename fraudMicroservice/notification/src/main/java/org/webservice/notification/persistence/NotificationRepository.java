package org.webservice.notification.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webservice.notification.persistence.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
