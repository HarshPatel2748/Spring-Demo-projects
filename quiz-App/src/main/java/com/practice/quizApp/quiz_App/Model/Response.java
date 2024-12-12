package com.practice.quizApp.quiz_App.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response
{
    private Integer id;
    private String response;
}
