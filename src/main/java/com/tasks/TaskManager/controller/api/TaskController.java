package com.tasks.TaskManager.controller.api;


import com.tasks.TaskManager.model.Task;
import com.tasks.TaskManager.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Task>> getTasks() {
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        Task task = taskRepository.findById(id).get();

        if (task != null) {
            return new ResponseEntity<>(taskRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        taskRepository.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
