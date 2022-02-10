package in.OnGrid.QuizPortal.service.impl;

import in.OnGrid.QuizPortal.dao.UserDao;
import in.OnGrid.QuizPortal.dao.UserSessionDao;
import in.OnGrid.QuizPortal.model.Entity.User;
import in.OnGrid.QuizPortal.model.Entity.UserSession;
import in.OnGrid.QuizPortal.model.dto.CreateUserRequest;
import in.OnGrid.QuizPortal.model.dto.LoginRequest;
import in.OnGrid.QuizPortal.model.dto.UpdateUserRequest;
import in.OnGrid.QuizPortal.service.UserService;
import in.OnGrid.QuizPortal.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserSessionService userSessionService;
    @Autowired
    UserSessionDao userSessionDao;

    @Override
    public UserSession createUser(CreateUserRequest request) {
        User user = new User();

        //To validate and set email
        if (request.getEmail() != null) {
            String email = request.getEmail();
            if (email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                if (userDao.findByEmail(email) == null)
                    user.setEmail(email);
                else
                    throw new IllegalArgumentException("Email already registered.");

            } else
                throw new IllegalArgumentException("Invalid Email");

        } else
            throw new IllegalArgumentException("Email cannot be null");


        //To validate and set name
        String name = request.getName();
        if (name != null) {
            if (name.matches("^[\\p{L} .'-]+$"))
                user.setName(name);
            else
                throw new IllegalArgumentException("Invalid name");
        } else
            throw new IllegalArgumentException("Name cannot be null");

        //To validate and set mobile number
        String mobile = request.getMobile();
        if (mobile != null) {
            if (mobile.matches("\\d{10}"))
                user.setMobile(mobile);
            else
                throw new IllegalArgumentException("Invalid mobile no.");
        } else
            throw new IllegalArgumentException("Mobile cannot be null");


        //To validate and set password
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();
        if (password != null && confirmPassword != null) {
            if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
                    && confirmPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                if (password.equals(confirmPassword)) {
                    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
                    user.setPassword(bCryptPasswordEncoder.encode(password));
                } else
                    throw new IllegalArgumentException("Password and confirm password should be same.");
            } else
                throw new IllegalArgumentException("Invalid Password or confirm password.");
        } else
            throw new IllegalArgumentException("Password cannot be null.");

        //Getting token for the user
        User user_cur = userDao.save(user);

        return userSessionService.createUserToken(user_cur);

    }

    @Override
    public User updateUser(String token, UpdateUserRequest request) {
        //To check user is authorized and currently logged in.
        if (userSessionService.checkAuthorization(token)) {
            //get the user
            User user = userSessionDao.findByToken(token).getUser();

            //Updating the fields
            //To validate and set name
            String name = request.getName();
            if (name != null) {
                if (name.matches("^[\\p{L} .'-]+$"))
                    user.setName(name);
                else
                    throw new IllegalArgumentException("Invalid name");
            }


            //To validate and set mobile
            String mobile = request.getMobile();
            if (mobile != null) {
                if (mobile.matches("\\d{10}"))
                    user.setMobile(mobile);
                else
                    throw new IllegalArgumentException("Invalid Mobile no.");
            }


            //To validate and set date
            Date dob = request.getDob();
//            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//            String strDate = formatter.format(dob);
//            System.out.println("Date Format with MM/dd/yyyy : "+strDate);
//
            if (dob != null) {
                Date dt = new Date();
                if (dob.compareTo(dt) > 0)
                    throw new IllegalArgumentException("Please enter a valid D.O.B");
                user.setDob(dob);
            }

            user.setGender(request.getGender());

            userDao.save(user);
            return user;

        } else
            throw new AccessDeniedException("User unauthorized");
    }

    @Override
    public User getUser(String token) {
        if (userSessionService.checkAuthorization(token)) {
            return userSessionDao.findByToken(token).getUser();
        } else
            throw new AccessDeniedException("User unauthorized");
    }

    @Override
    public String userLogin(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (email != null && password != null) {
            if (email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                //Get user
                User user = userDao.findByEmail(email);

                if (user == null)
                    throw new IllegalArgumentException("Invalid email");

                String savedPassword = user.getPassword();
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

                if (bCryptPasswordEncoder.matches(password, savedPassword)) {
                    //Get token
                    return userSessionService.createUserToken(user).getToken();
                } else
                    throw new IllegalArgumentException("Please enter a valid password");
            } else
                throw new IllegalArgumentException("Please enter a valid email");
        } else
            throw new IllegalArgumentException("Please enter email and password");
    }

    @Override
    public void userLogout(String token) {
        if (userSessionService.checkAuthorization(token)) {
            userSessionService.UserLogout(token);

        } else
            throw new AccessDeniedException("User Unauthorized");
    }
}
