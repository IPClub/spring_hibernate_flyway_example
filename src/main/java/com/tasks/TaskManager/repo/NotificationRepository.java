package com.tasks.TaskManager.repo;
import java.util.Collection;

import com.tasks.TaskManager.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
    Collection<Notification> findAll();
}