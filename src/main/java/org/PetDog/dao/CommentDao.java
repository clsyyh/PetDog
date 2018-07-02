package org.PetDog.dao;

import org.PetDog.entity.Comment;

import java.util.List;

public interface CommentDao {
    public Comment selectById(Integer id);
    public List<Comment> selectByQuestionId(Integer id);
    public int addComment(Comment comment);
}
