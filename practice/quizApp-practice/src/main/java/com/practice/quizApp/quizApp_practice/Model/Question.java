package com.practice.quizApp.quizApp_practice.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;
    private String answer;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String category;
    private String difficulty;
}
