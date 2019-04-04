package com.shop.partsshop.dao;

import com.shop.partsshop.dao.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAllByProduct_Id(long id);
}
