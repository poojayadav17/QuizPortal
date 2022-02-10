package in.OnGrid.QuizPortal.controller;

import in.OnGrid.QuizPortal.model.Entity.User;
import in.OnGrid.QuizPortal.model.Entity.UserSession;
import in.OnGrid.QuizPortal.model.dto.BaseResponse;
import in.OnGrid.QuizPortal.model.dto.CreateUserRequest;
import in.OnGrid.QuizPortal.model.dto.LoginRequest;
import in.OnGrid.QuizPortal.model.dto.UpdateUserRequest;
import in.OnGrid.QuizPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public BaseResponse<UserSession> createUser(@RequestBody CreateUserRequest request) {
        return new BaseResponse<>(HttpStatus.OK.value(), userService.createUser(request));
    }

    @PostMapping(path = "/update")
    public BaseResponse<User> updateUser(@RequestHeader("Authorization") String token, @RequestBody UpdateUserRequest request) {
        User user = userService.updateUser(token, request);
        return new BaseResponse<>(HttpStatus.OK.value(), "Success", user);
    }

    @GetMapping(path = "/profile")
    public BaseResponse<User> getUser(@RequestHeader("Authorization") String token) {
        User user = userService.getUser(token);
        return new BaseResponse<User>(HttpStatus.OK.value(), "Success", user);
    }

    //login
    @PostMapping(path = "/login")
    public BaseResponse<String> userLogin(@RequestBody LoginRequest request) {
        String tokenString = userService.userLogin(request);
        return new BaseResponse<String>(HttpStatus.OK.value(), "Success", tokenString);
    }

    //logout
    @PostMapping(path = "/logout")
    public BaseResponse<?> userLogout(@RequestHeader("Authorization") String token) {
        userService.userLogout(token);
        return new BaseResponse<>(HttpStatus.OK.value(), "Successfully");
    }
}
