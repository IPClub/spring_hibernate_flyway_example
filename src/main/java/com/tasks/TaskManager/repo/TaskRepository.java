package com.tasks.TaskManager.repo;

import java.util.Collection;

import com.tasks.TaskManager.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Collection<Task> findAll();
}
