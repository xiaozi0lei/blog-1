package cn.sunguolei.blog.webfront.utils;

import cn.sunguolei.blog.webfront.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserUtil {
    private final static String TOKEN_PREFIX = "Bearer ";

    /**
     * 获取用户登录信息
     *
     * @param request      http 请求
     * @param loginService 登录相关 service
     * @return 用户登录状态和用户信息
     */
    public static Map<String, String> getUserIdentity(HttpServletRequest request, LoginService loginService) {

        Map<String, String> userInfoMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        String token;

        if (null != cookies) {
            // 获取 token
            token = getToken(request);

            if (null != token) {
                token = "Bearer " + token;
                // 获取用户登录信息
                userInfoMap = loginService.getUserIdentity(token);
            }
        } else {
            userInfoMap.put("isLogin", "false");
        }
        // 返回用户登录状态和用户信息
        return userInfoMap;
    }

    /**
     * 从 request 中获取 token
     *
     * @param request http 请求
     * @return 返回 token 或者 null
     */
    public static String getToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = null;

        // 遍历所有的 cookie，查找 key 为 token 的 cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = TOKEN_PREFIX + cookie.getValue();
                break;
            }
        }

        return token;
    }
}
