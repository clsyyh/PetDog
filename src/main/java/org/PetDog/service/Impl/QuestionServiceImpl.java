package org.PetDog.service.Impl;

import org.PetDog.dao.QuestionDao;
import org.PetDog.entity.Question;
import org.PetDog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("questionService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDao questionDao;
    @Transactional(readOnly = true)
    public List<Question> findAll() {
        return questionDao.findAll();
    }
    @Transactional(readOnly = true)
    public Question selectById(Integer id) {
        return questionDao.selectById(id);
    }

    public int addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }
}
