package cn.sunguolei.blog.webfront.controller;

import cn.sunguolei.blog.webfront.service.LoginService;
import cn.sunguolei.blog.webfront.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;

    // 注入 loginService
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 用户登录
     *
     * @param response 设置 cookie
     * @param username 提交的表单中的 username
     * @param password 提交的表单中的 password
     * @return 返回页面模板
     */
    @PostMapping("/login")
    public String login(HttpServletResponse response, @RequestParam("username") String username,
                        @RequestParam("password") String password) {

        // map 存放用户名和密码
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        // 验证用户名密码，同时获取用户 token
        String token = loginService.login(map).trim();

        // token 存放到 cookie 中，并设置到期时间为 30 天
        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(30 * 24 * 60 * 60);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);

        return "index";
    }

    /**
     * 获取用户相关信息
     *
     * @param request http 请求
     * @return 返回用户是否登录及用户相关信息的 map
     */
    @GetMapping("/getUserIdentity")
    @ResponseBody
    public Map<String, String> getUserIdentity(HttpServletRequest request) {
        return UserUtil.getUserIdentity(request, loginService);
    }

}
