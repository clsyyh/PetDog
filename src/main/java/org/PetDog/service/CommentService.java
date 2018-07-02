package org.PetDog.service;

import org.PetDog.entity.Comment;

import java.util.List;

public interface CommentService {
    public Comment selectById(Integer id);
    public List<Comment> selectByQuestionId(Integer id);
    public int addComment(Comment comment);
}
