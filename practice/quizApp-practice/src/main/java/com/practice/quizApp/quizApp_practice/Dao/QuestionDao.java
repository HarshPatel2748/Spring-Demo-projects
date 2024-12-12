package com.practice.quizApp.quizApp_practice.Dao;


import com.practice.quizApp.quizApp_practice.Model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByDifficulty(String difficulty);

    @Query(value ="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category,int numQ);
}
