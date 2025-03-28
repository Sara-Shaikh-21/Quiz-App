package com.sara.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sara.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategoryIgnoreCase(String category);
    
    @Query(value = "SELECT * FROM question q Where q.category =:category ORDER BY RANDOM() LIMIT :numOfQues", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numOfQues);


}
