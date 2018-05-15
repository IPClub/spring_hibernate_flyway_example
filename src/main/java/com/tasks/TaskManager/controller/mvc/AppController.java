package com.tasks.TaskManager.controller.mvc;

import com.tasks.TaskManager.model.Comment;
import com.tasks.TaskManager.model.Task;
import com.tasks.TaskManager.model.User;
import com.tasks.TaskManager.repo.CommentRepository;
import com.tasks.TaskManager.repo.TaskRepository;
import com.tasks.TaskManager.repo.UserRepository;
import com.tasks.TaskManager.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AppService appService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUserPage(Map<String, Object> model) {
        return "addUser";
    }

    @RequestMapping(value ="/addComment", params = {"task_id"})
    public String addCommentPage(@RequestParam(value = "task_id") Long id,Map<String, Object> model) {
        model.put("task_id",id);
        return "addComment";
    }

    @RequestMapping("/addTask")
    public String addTaskPage(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        return "addTask";
    }

    @RequestMapping("/editTask/{id}")
    public String editTaskPage(@PathVariable Long id, Map<String, Object> model) {
        model.put("task", taskRepository.findById(id).get());
        model.put("users", userRepository.findAll());
        return "editTask";
    }

    @RequestMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id, Map<String, Object> model) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/saveComment",method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("comment") Comment comment,@RequestParam("task_id") Long taskId) {
        appService.saveComment(comment,taskId);
        return "redirect:/editTask/"+taskId;
    }
    @RequestMapping("/deleteComment/{task_id}/{comment_id}")
    public String deleteComment(@PathVariable("task_id") Long taskId,@PathVariable("comment_id") Long commentId, Map<String, Object> model) {
        commentRepository.deleteById(commentId);
        return "redirect:/editTask/"+taskId;
    }


    @RequestMapping(value = "/saveTask",method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task,@RequestParam("userId") Long userId) {
        appService.saveTask(task,userId);
        return "redirect:/";
    }

}
