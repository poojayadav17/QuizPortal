package in.OnGrid.QuizPortal.controller;

import in.OnGrid.QuizPortal.model.Entity.Question;
import in.OnGrid.QuizPortal.model.dto.BaseResponse;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuestionRequest;
import in.OnGrid.QuizPortal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping(path = "/quizzes/{quizId}/question")
    public BaseResponse<Question> createQuestion(@RequestBody CreateUpdateQuestionRequest request, @PathVariable("quizId") int quizId) {
        Question question = questionService.createQuestion(request, quizId);
        return new BaseResponse<Question>(HttpStatus.OK.value(), "Success", question);
    }

    @PostMapping(path = "/questions/{questionId}")
    public BaseResponse<Question> updateQuestion(@RequestBody CreateUpdateQuestionRequest request,
                                                 @PathVariable("questionId") int questionId) {
        Question question = questionService.updateQuestion(questionId, request);
        return new BaseResponse<Question>(HttpStatus.OK.value(), "Success", question);
    }

    @GetMapping(path = "/quizzes/{quizId}/questions")
    public BaseResponse<List<Question>> getQuestions(@PathVariable("quizId") int quizId) {
        List<Question> questionList = questionService.getQuestions(quizId);
        return new BaseResponse<List<Question>>(HttpStatus.OK.value(), "Success", questionList);
    }

    @GetMapping(path = "/questions/{questionId}")
    public BaseResponse<Question> getQuestion(@PathVariable("questionId") int questionId) {
        Question question = questionService.getQuestion(questionId);
        return new BaseResponse<Question>(HttpStatus.OK.value(), "Success", question);
    }
}
