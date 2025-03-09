package com.sara.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.quizapp.Question;
import com.sara.quizapp.dao.QuestionDao;

@Service
public class QuestionService {
    @Autowired
    QuestionDao queDao;

    public List<Question> getAllQuestions(){
        return queDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category){
        return queDao.findByCategoryIgnoreCase(category);
    }
}
