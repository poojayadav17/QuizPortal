package in.OnGrid.QuizPortal.service;

import in.OnGrid.QuizPortal.model.Entity.User;
import in.OnGrid.QuizPortal.model.Entity.UserSession;
import in.OnGrid.QuizPortal.model.dto.CreateUserRequest;
import in.OnGrid.QuizPortal.model.dto.LoginRequest;
import in.OnGrid.QuizPortal.model.dto.UpdateUserRequest;


public interface UserService {
    UserSession createUser(CreateUserRequest request);

    User updateUser(String token, UpdateUserRequest request);

    User getUser(String token);

    String userLogin(LoginRequest request);

    void userLogout(String token);
}
