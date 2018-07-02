package org.PetDog.service;

import org.PetDog.entity.Comment;
import org.PetDog.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    Question selectById(Integer id);
    int addQuestion(Question question);
}
