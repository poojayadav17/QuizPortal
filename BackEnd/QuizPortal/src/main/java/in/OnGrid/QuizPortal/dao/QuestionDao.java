package in.OnGrid.QuizPortal.dao;

import in.OnGrid.QuizPortal.model.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
//    Question findByQuestionId(Integer QuestionId);
}
