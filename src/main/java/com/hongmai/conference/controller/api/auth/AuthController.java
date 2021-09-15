package com.hongmai.conference.controller.api.auth;

import com.hongmai.conference.model.param.*;
import com.hongmai.conference.model.vo.UserVO;
import com.hongmai.conference.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserVO login(@RequestBody @Validated LoginParam user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Validated RegisterParam user) {
        userService.register(user);
    }

    @PostMapping("/register/sendAuthEmail")
    public void sendAuthEmail(@RequestBody @Validated AuthEmailParam param) {
        userService.sendAuthEmail(param);
    }

    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody @Validated ResetPasswordParam param) {
        userService.resetPassword(param);
    }
    @PostMapping("/resetPassword/sendResetPasswordEmail")
    public void sendResetPasswordEmail(@RequestBody @Validated ResetPasswordRequestParam param) {
        userService.sendResetPasswordEmail(param);
    }
}