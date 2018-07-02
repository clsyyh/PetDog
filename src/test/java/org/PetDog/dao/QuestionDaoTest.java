package org.PetDog.dao;

import org.PetDog.entity.Question;
import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class QuestionDaoTest {
    @Resource
    private QuestionDao questionDao;
    @Resource
    private UserDao userDao;
    @Test
    public void findAll() throws Exception {
        List<Question> questions=questionDao.findAll();
        for(Question question:questions){
            System.out.println(question.getUser().getLoginname());
        }
    }

    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void addQuestion() throws Exception {
        User user=userDao.findUserById(4);
        Question question=new Question();
        question.setContent("gdpojhpoh");
        question.setTitle("lghd");
        question.setUser(user);
        questionDao.addQuestion(question);

    }

}