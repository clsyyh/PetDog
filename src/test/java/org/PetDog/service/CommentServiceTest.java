package org.PetDog.service;

import org.PetDog.dao.UserDao;
import org.PetDog.entity.Comment;
import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class CommentServiceTest {
    @Resource
    private CommentService commentService;
    @Resource
    private UserDao userDao;
    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void selectByQuestionId() throws Exception {
    }

    @Test
    public void addComment() throws Exception {
        User user=userDao.findUserById(4);
        Comment comment=new Comment();
        comment.setUser(user);
        comment.setQuestionId(1);
        comment.setComment("hflsdgndkjf");
        commentService.addComment(comment);
    }

}