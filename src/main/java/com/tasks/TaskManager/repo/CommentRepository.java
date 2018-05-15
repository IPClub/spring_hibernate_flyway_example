package com.tasks.TaskManager.repo;

import java.util.Collection;

import com.tasks.TaskManager.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Collection<Comment> findAll();
}
