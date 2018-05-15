package com.tasks.TaskManager.controller.api;


import com.tasks.TaskManager.model.Notification;
import com.tasks.TaskManager.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Notification>> getNotifications() {
        return new ResponseEntity<>(notificationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Notification> getNotification(@PathVariable long id) {
        Notification notification = notificationRepository.findById(id).get();

        if (notification != null) {
            return new ResponseEntity<>(notificationRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNotification(@RequestBody Notification notification) {
        return new ResponseEntity<>(notificationRepository.save(notification), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteNotification(@PathVariable long id) {
        notificationRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
