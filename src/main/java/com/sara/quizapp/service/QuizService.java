package com.sara.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sara.quizapp.dao.QuestionDao;
import com.sara.quizapp.dao.QuizDao;
import com.sara.quizapp.model.Quiz;
import com.sara.quizapp.model.Question;
import com.sara.quizapp.model.QuestionWrapper;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionsDao;

    public ResponseEntity<String> createQuiz(String category,int numberOfQues,String title){
        // try{
            List<Question> questionsForQuiz=questionsDao.findRandomQuestionsByCategory(category,numberOfQues);
            
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questionsForQuiz);
            quizDao.save(quiz);

            return new ResponseEntity<>("Successfully Created the Quiz!",HttpStatus.CREATED);

        // }
        // catch(Exception ex){
        //     ex.printStackTrace();
        // }
        // return new ResponseEntity<>("UnSuccessful Attempt!",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        try{
            
            Optional<Quiz> quiz=quizDao.findById(id);
            List<Question> quesFromDb=quiz.get().getQuestions();
            List<QuestionWrapper> quesForUser=new ArrayList<>();
            for(Question q:quesFromDb){
                QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
                quesForUser.add(qw);
            }
            return new ResponseEntity<>(quesForUser,HttpStatus.OK);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    

}
