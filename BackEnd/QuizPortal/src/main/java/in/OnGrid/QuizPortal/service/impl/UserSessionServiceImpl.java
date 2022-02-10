package in.OnGrid.QuizPortal.service.impl;

import in.OnGrid.QuizPortal.dao.UserSessionDao;
import in.OnGrid.QuizPortal.model.Entity.User;
import in.OnGrid.QuizPortal.model.Entity.UserSession;
import in.OnGrid.QuizPortal.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserSessionServiceImpl implements UserSessionService {
    @Autowired
    UserSessionDao userSessionDao;

    @Override
    public UserSession createUserToken(User user) {
        UserSession userSession = new UserSession();

        //Generate a token
//        Random random = new Random();
//        String token = "";
//        for (int i = 0; i < 20; i++)
//            token = token + (char) (random.nextInt(26) + 97) + (String.valueOf(random.nextInt(100)));

        String token = UUID.randomUUID().toString();
        userSession.setToken(token);

        LocalDateTime dateTime = LocalDateTime.now();
        //Set the fields
        userSession.setSignInTime(dateTime);
        userSession.setUser(user);

        userSessionDao.save(userSession);
        return userSession;
    }

    @Override
    public void UserLogout(String token) {
        //Get the logged in user
        UserSession loggedInUser = userSessionDao.findByToken(token);


        //Check if already logged out
        if (loggedInUser.getSignOutTime() == null) {
            LocalDateTime dateTime = LocalDateTime.now();
            loggedInUser.setSignOutTime(dateTime);
            userSessionDao.save(loggedInUser);
        } else
            throw new RuntimeException("User is already logout.");
    }

    @Override
    public Boolean checkAuthorization(String token) {
        UserSession userSession = userSessionDao.findByToken(token);
        return  userSession != null && userSession.getSignOutTime() == null;
    }
}