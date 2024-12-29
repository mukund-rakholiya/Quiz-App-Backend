package com.quiz.Quiz_App.Service;

import com.quiz.Quiz_App.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class QuestionService {
    private final Set<Long> answeredQuestion = new HashSet<>();
    private int correctCount = 0;
    private int incorrectCount = 0;

    public void startNewSession() {
        answeredQuestion.clear();
        correctCount = 0;
        incorrectCount = 0;
    }

    public boolean isAnswered(Long questionId) {
        return answeredQuestion.contains(questionId);
    }

    public void recordAnswer(Long questionId, boolean isCorrect) {
        answeredQuestion.add(questionId);
        if (isCorrect) correctCount++;
        else incorrectCount++;
    }

    public Map<String, Object> getStats() {
        return Map.of(
                "totalAnswered", answeredQuestion.size(),
                "correct", correctCount,
                "incorrect", incorrectCount
        );
    }
}
