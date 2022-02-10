package in.OnGrid.QuizPortal.service.impl;

import in.OnGrid.QuizPortal.dao.QuestionDao;
import in.OnGrid.QuizPortal.dao.QuizDao;
import in.OnGrid.QuizPortal.model.Entity.Question;
import in.OnGrid.QuizPortal.model.Entity.Quiz;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuizRequest;
import in.OnGrid.QuizPortal.model.dto.ResultResponse;
import in.OnGrid.QuizPortal.model.dto.SubmitRequest;
import in.OnGrid.QuizPortal.service.QuizService;
import in.OnGrid.QuizPortal.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    @Autowired
    UserSessionService userSessionService;

    @Override
    public Quiz createQuiz(CreateUpdateQuizRequest request) {
        Quiz quiz = new Quiz();

        if (request.getDescription() != null)
            quiz.setDescription(request.getDescription());
        else
            throw new IllegalArgumentException("Description cannot be null.");
        if (request.getImage() != null)
            quiz.setImage(request.getImage());
        else
            throw new IllegalArgumentException("Image cannot be null.");

        return quizDao.save(quiz);
    }

    @Override
    public Quiz updateQuiz(CreateUpdateQuizRequest request, int quizId) {
        Quiz quiz = quizDao.findById(quizId).orElse(null);
        if (quiz == null)
            throw new IllegalArgumentException("No quiz found by this id.");

        if (request.getDescription() != null)
            quiz.setDescription(request.getDescription());
        if (request.getImage() != null)
            quiz.setImage(request.getImage());

        quizDao.save(quiz);

        return quiz;
    }

    @Override
    public List<Quiz> getQuizzes(String token) {
        if (userSessionService.checkAuthorization(token)) {
            List<Quiz> quizzes = quizDao.findAll();
            return quizzes;
        } else
            throw new IllegalArgumentException("User unauthorized");

    }

    @Override
    public Quiz getQuiz(int quizId, String token) {
        if (userSessionService.checkAuthorization(token)) {
            return quizDao.getById(quizId);
        } else
            throw new IllegalArgumentException("User unauthorized");
    }

    @Override
    public ResultResponse getResult(List<SubmitRequest> request, int quizId, String token) {
        if (userSessionService.checkAuthorization(token)) {
            //Get that particular quiz
            Quiz quiz = quizDao.getById(quizId);

            //Get the list of questions in that quiz.
            List<Question> questions = quiz.getQuestions();

            int score = 0, wrong = 0;
            for (SubmitRequest listOfAnswers : request) {
                //Get each questionsId and answer
                int quesId = listOfAnswers.getId();
                boolean chosenAnswer = listOfAnswers.getAnswer();

                //Get the correct answer from db
                for (Question q : questions) {
                    if (q.getId() == quesId) {
                        if (q.isAnswer() == chosenAnswer)
                            score++;
                        else
                            wrong++;
                        break;
                    }
                }
            }

            ResultResponse result = new ResultResponse();
            result.setScore(score);
            result.setWrong(wrong);
            return result;
        } else
            throw new IllegalArgumentException("User not logged in.");
    }
}
