package com.practice.quizApp.quizApp_practice.Service;

import com.practice.quizApp.quizApp_practice.Model.Question;

import com.practice.quizApp.quizApp_practice.Dao.QuestionDao;
import com.practice.quizApp.quizApp_practice.Dao.QuizDao;
import com.practice.quizApp.quizApp_practice.Model.QuestionWrapper;
import com.practice.quizApp.quizApp_practice.Model.Quiz;
import com.practice.quizApp.quizApp_practice.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id){
        Quiz quiz =quizDao.findById(id).get();
        List<Question>questionsFromDB = quiz.getQuestions();

        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question question:questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(question.getId(), question.getQuestion(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int right = 0;//marks
        int i=0; //count

        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
