package com.shop.partsshop.manager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shop.partsshop.dao.CommentRepo;
import com.shop.partsshop.dao.entity.Comment;
import com.shop.partsshop.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager {

    private CommentRepo commentRepo;
    @Autowired
    public CommentManager(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Optional<Comment> findById(long id) {
        return commentRepo.findById(id);
    }

    public Iterable<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }
    public List<Comment> findAllByProduct_Id(long id)
    {
        return commentRepo.findAllByProduct_Id(id);
    }
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase()
    {
        save(new Comment("Witam1"));
        save(new Comment("Witam2"));
    }
}
