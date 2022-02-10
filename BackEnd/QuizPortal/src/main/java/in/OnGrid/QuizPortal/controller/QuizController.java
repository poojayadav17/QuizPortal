package in.OnGrid.QuizPortal.controller;

import in.OnGrid.QuizPortal.model.Entity.Quiz;
import in.OnGrid.QuizPortal.model.dto.BaseResponse;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuizRequest;
import in.OnGrid.QuizPortal.model.dto.ResultResponse;
import in.OnGrid.QuizPortal.model.dto.SubmitRequest;
import in.OnGrid.QuizPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quizzes")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping
    public BaseResponse<Quiz> createQuiz(@RequestBody CreateUpdateQuizRequest request) {
        Quiz quiz = quizService.createQuiz(request);
        return new BaseResponse<Quiz>(HttpStatus.OK.value(), "Success", quiz);
    }

    @PostMapping(path = "/{quizId}")
    public BaseResponse<Quiz> updateQuiz(@RequestBody CreateUpdateQuizRequest request,
                                         @PathVariable("quizId") int quizId) {
        Quiz quiz = quizService.updateQuiz(request, quizId);
        return new BaseResponse<Quiz>(HttpStatus.OK.value(), "Success", quiz);
    }

    @GetMapping
    public BaseResponse<List<Quiz>> getQuizzes(@RequestHeader("Authorization") String token) {
        List<Quiz> quizzes = quizService.getQuizzes(token);
        return new BaseResponse<List<Quiz>>(HttpStatus.OK.value(), "Success", quizzes);
    }

    @GetMapping(path = "/{quizId}")
    public BaseResponse<Quiz> getQuiz(@RequestHeader("Authorization") String token, @PathVariable("quizId") int quizId) {
        Quiz quiz = quizService.getQuiz(quizId, token);
        return new BaseResponse<Quiz>(HttpStatus.OK.value(), "Success", quiz);
    }

    @PostMapping(path = "/{quizId}/submit")
    public BaseResponse<ResultResponse> getResult(@RequestHeader("Authorization") String token, @RequestBody List<SubmitRequest> request, @PathVariable("quizId") int quizId) {
        ResultResponse result = quizService.getResult(request, quizId, token);
        return new BaseResponse<ResultResponse>(HttpStatus.OK.value(), "Success", result);
    }
}
