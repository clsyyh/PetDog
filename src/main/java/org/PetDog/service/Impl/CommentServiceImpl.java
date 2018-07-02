package org.PetDog.service.Impl;

import org.PetDog.dao.CommentDao;
import org.PetDog.entity.Comment;
import org.PetDog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;
    @Transactional(readOnly = true)
    public Comment selectById(Integer id) {
        return commentDao.selectById(id);
    }
    @Transactional(readOnly = true)
    public List<Comment> selectByQuestionId(Integer id) {
        return commentDao.selectByQuestionId(id);
    }

    public int addComment(Comment comment) {
        System.out.println("*(&*9896735049675-3534");
        return commentDao.addComment(comment);
    }
}
