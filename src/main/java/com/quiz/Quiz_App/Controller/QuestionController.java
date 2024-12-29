package com.quiz.Quiz_App.Controller;

import com.quiz.Quiz_App.Model.QuestionModel;
import com.quiz.Quiz_App.Repository.QuestionRepository;
import com.quiz.Quiz_App.ResponseDTO;
import com.quiz.Quiz_App.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/quiz")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/start")
    public ResponseDTO<String> startQuiz() {
        questionService.startNewSession();
        return new ResponseDTO<>(HttpStatus.OK, "New session started successfully!");
    }

    @GetMapping("/questions")
    public ResponseDTO<List<Object>> getQuestion() {
        List<QuestionModel> questions = questionRepository.findAll();
        List<QuestionModel> unansweredQuestions = questions.stream()
                .filter(q -> !questionService.isAnswered(q.getId()))
                .toList();

        if (unansweredQuestions.isEmpty())
            return new ResponseDTO<>(null, "No further Question", HttpStatus.OK);

        QuestionModel randomQuestion = unansweredQuestions.get(new Random().nextInt(unansweredQuestions.size()));
        return new ResponseDTO<>(List.of(randomQuestion.getId(), randomQuestion.getQuestion(), randomQuestion.getOptions()), "Question fetched successfully", HttpStatus.OK);

    }

    @PostMapping("/answer")
    public ResponseDTO<String> submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        Optional<QuestionModel> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isEmpty())
            return new ResponseDTO<>(null, "Invalid question Id", HttpStatus.BAD_REQUEST);

        QuestionModel question = optionalQuestion.get();
        boolean isCorrect = question.getCorrectAnswer().equals(answer);
        questionService.recordAnswer(questionId, isCorrect);

        return new ResponseDTO<>(HttpStatus.OK, isCorrect ? "Correct answer!" : "Incorrect answer");
    }

    @GetMapping("/stats")
    public ResponseDTO<Map<String, Object>> getStats() {
        return new ResponseDTO<>(questionService.getStats(), "Stats fetched successfully", HttpStatus.OK);
    }
}
