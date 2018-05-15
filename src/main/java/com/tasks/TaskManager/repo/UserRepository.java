package com.tasks.TaskManager.repo;

import java.util.Collection;

import com.tasks.TaskManager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Collection<User> findAll();
}