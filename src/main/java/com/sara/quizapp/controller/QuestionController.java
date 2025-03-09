package com.sara.quizapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sara.quizapp.Question;
import com.sara.quizapp.service.QuestionService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("question")

public class QuestionController{
    @Autowired
    QuestionService queService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return queService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return queService.getQuestionsByCategory(category);
    }
}
