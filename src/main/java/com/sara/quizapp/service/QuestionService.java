package com.sara.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sara.quizapp.dao.QuestionDao;
import com.sara.quizapp.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionDao queDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(queDao.findAll(),HttpStatus.OK) ;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST) ;

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(queDao.findByCategoryIgnoreCase(category),HttpStatus.OK);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            queDao.save(question);
            return new ResponseEntity<>("Sucessfully Added!",HttpStatus.CREATED);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);

    }
}
