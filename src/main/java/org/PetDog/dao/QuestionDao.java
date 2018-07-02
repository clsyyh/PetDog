package org.PetDog.dao;

import org.PetDog.entity.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
    Question selectById(Integer id);
    int addQuestion(Question question);
}
