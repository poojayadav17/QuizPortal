package in.OnGrid.QuizPortal.service;

import in.OnGrid.QuizPortal.model.Entity.Quiz;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuizRequest;
import in.OnGrid.QuizPortal.model.dto.ResultResponse;
import in.OnGrid.QuizPortal.model.dto.SubmitRequest;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(CreateUpdateQuizRequest request);

    Quiz updateQuiz(CreateUpdateQuizRequest request, int quizId);

    List<Quiz> getQuizzes(String token);

    Quiz getQuiz(int quizId, String token);

    ResultResponse getResult(List<SubmitRequest> request, int quizId, String token);
}
