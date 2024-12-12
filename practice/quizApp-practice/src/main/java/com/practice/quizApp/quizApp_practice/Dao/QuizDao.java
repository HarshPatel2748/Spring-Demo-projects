package com.practice.quizApp.quizApp_practice.Dao;

import com.practice.quizApp.quizApp_practice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
