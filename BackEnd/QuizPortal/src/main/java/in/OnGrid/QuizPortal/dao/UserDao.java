package in.OnGrid.QuizPortal.dao;

import in.OnGrid.QuizPortal.model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByMobile(String mobile);
}
