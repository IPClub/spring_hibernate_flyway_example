package com.tasks.TaskManager.controller.api;

import com.tasks.TaskManager.model.Comment;
import com.tasks.TaskManager.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Comment>> getComments() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getComment(@PathVariable long id) {
        Comment comment = commentRepository.findById(id).get();

        if (comment != null) {
            return new ResponseEntity<>(commentRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable long id) {
        commentRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
