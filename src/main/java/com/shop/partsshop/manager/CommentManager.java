package com.shop.partsshop.manager;

import com.shop.partsshop.dao.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentManager {
    private CommentRepo commentRepo;

    @Autowired
    public CommentManager(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
}
