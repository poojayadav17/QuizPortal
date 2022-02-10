package in.OnGrid.QuizPortal.dao;

import in.OnGrid.QuizPortal.model.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
