package in.OnGrid.QuizPortal.service.impl;

import in.OnGrid.QuizPortal.dao.QuestionDao;
import in.OnGrid.QuizPortal.dao.QuizDao;
import in.OnGrid.QuizPortal.model.Entity.Question;
import in.OnGrid.QuizPortal.model.Entity.Quiz;
import in.OnGrid.QuizPortal.model.dto.CreateUpdateQuestionRequest;
import in.OnGrid.QuizPortal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuizDao quizDao;

    @Override
    public Question createQuestion(CreateUpdateQuestionRequest request, int quizId) {
        Question question = new Question();

        if (request.getDescription() != null && request.getAnswer() != null) {
            question.setDescription(request.getDescription());
            question.setAnswer(request.getAnswer());
        }

        Quiz quiz = quizDao.getById(quizId);
        question.setQuiz(quiz);
        quiz.getQuestions().add(question);
        quizDao.save(quiz);

        return questionDao.save(question);
    }

    @Override
    public Question updateQuestion(int questionId, CreateUpdateQuestionRequest request) {
        Question question = questionDao.getById(questionId);

        if (request.getDescription() != null)
            question.setDescription(request.getDescription());
        if (request.getAnswer() != null)
            question.setAnswer(request.getAnswer());

        questionDao.save(question);

        return question;
    }

    @Override
    public List<Question> getQuestions(int quizId) {
        return quizDao.getById(quizId).getQuestions();
    }

    @Override
    public Question getQuestion(int questionId) {
        return questionDao.getById(questionId);

    }
}
