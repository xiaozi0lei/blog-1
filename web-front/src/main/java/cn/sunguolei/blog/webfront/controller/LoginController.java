package cn.sunguolei.blog.webfront.controller;

import cn.sunguolei.blog.webfront.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response, @RequestParam("username") String username,
                        @RequestParam("password") String password, Model model) {
        logger.debug("username is {}, password is {}", username, password);
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        String token = loginService.loginTest(map).trim();
        final String HEADER_STRING = "Authorization";
        final String TOKEN_PREFIX = "Bearer ";
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

        logger.debug(token);

        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(30 * 24 * 60 * 60);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);

        model.addAttribute("username", username);

        return "index";
    }

    @GetMapping("/getUserIdentity")
    @ResponseBody
    public Map<String, String> getUserIdentity(HttpServletRequest request) {

        Map<String, String> userInfoMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        String token = null;

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }

            if (null != token) {
                token = "Bearer " + token;

                Map<String, String> hello;
                hello = loginService.getUserIdentity(token);
                return hello;
            }
        }
        userInfoMap.put("isLogin", "false");

        return userInfoMap;
    }

    @GetMapping("/testNote")
    public String testNote(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();

        return testMethod("testNote", cookies, model);
    }

    private String testMethod(String methodName, Cookie[] cookies, Model model) {
        String token = null;

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }

            if (null != token) {
                token = "Bearer " + token;
                Class clazz = loginService.getClass();
                String hello = null;
                try {
                    hello = (String) clazz.getDeclaredMethod(methodName, String.class).invoke(loginService, token);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                model.addAttribute("hello", hello);
                return "test";
            }
        }
        return "redirect:/login";
    }
}
