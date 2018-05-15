package com.tasks.TaskManager.service;

import com.tasks.TaskManager.model.Comment;
import com.tasks.TaskManager.model.Task;
import com.tasks.TaskManager.model.User;
import com.tasks.TaskManager.repo.CommentRepository;
import com.tasks.TaskManager.repo.TaskRepository;
import com.tasks.TaskManager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void saveTask(Task task,Long userId){
        User userById = userRepository.findById(userId).get();
        task.setUser(userById);
        taskRepository.save(task);
    }

    @Transactional
    public void saveComment(Comment comment, Long taskId){
        Task taskById = taskRepository.findById(taskId).get();
        comment.setTask(taskById);
        commentRepository.save(comment);
    }
}
