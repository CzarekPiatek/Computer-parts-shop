package com.shop.partsshop.api;

import com.shop.partsshop.dao.entity.Comment;
import com.shop.partsshop.manager.CommentManager;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentAPI {
    private CommentManager commentManager;

    public CommentAPI(CommentManager commentManager) {
        this.commentManager = commentManager;
    }

    //pobierz wsystkie komentarze
    @GetMapping("/all")
    public Iterable<Comment> getAll() {
        return commentManager.findAll();
    }

    //pobierz komentarz o danym id
    @GetMapping("/{id}")
    public Optional<Comment> getId(@PathVariable long id) {
        return commentManager.findById(id);
    }

    //dodaj komentarz
    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentManager.save(comment);
    }

    //nadpisz komentarz
    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentManager.save(comment);
    }

    //usun komentarz o danym id
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable long id) {
        commentManager.deleteById(id);
    }
}
