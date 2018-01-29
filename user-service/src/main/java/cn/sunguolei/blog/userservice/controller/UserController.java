package cn.sunguolei.blog.userservice.controller;

import cn.sunguolei.blog.userservice.domain.User;
import cn.sunguolei.blog.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findUserByUsername")
    public User findUserByUsername(@RequestBody String username) {
        return userService.findUserByUsername(username);
    }
}
