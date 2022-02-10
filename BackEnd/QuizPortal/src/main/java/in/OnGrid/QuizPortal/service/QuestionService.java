package in.OnGrid.QuizPortal.service;

import in.OnGrid.QuizPortal.model.Entity.Question;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuestionRequest;

import java.util.List;

public interface QuestionService {
    Question createQuestion(CreateUpdateQuestionRequest request, int quizId);

    Question updateQuestion(int questionId, CreateUpdateQuestionRequest request);

    List<Question> getQuestions(int quizId);

    Question getQuestion(int questionId);
}
