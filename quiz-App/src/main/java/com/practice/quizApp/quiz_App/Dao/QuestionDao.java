package com.practice.quizApp.quiz_App.Dao;

import com.practice.quizApp.quiz_App.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer>{

    @Query("SELECT e.id FROM Question e")
    List<Integer> findAllIds();

    List<Question> findAllByCategory(String category);

    @Query(value ="SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category,int numQ);
}
