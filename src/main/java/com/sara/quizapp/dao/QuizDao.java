package com.sara.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sara.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}