package com.shop.partsshop.api;

import com.shop.partsshop.manager.CommentManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentAPI {
    private CommentManager commentManager;

    public CommentAPI(CommentManager commentManager)
    {
        this.commentManager = commentManager;
    }
}
