package com.practice.quizApp.quiz_App.Dao;

import com.practice.quizApp.quiz_App.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}