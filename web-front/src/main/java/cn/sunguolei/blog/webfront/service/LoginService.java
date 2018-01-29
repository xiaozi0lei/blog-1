package cn.sunguolei.blog.webfront.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient("zuul")
public interface LoginService {

    /**
     * 用户登录，获取 token
     *
     * @param map 存放用户名和密码
     * @return 返回用户 token
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    String login(@RequestBody Map<String, String> map);

    /**
     * 获取用户的相关信息
     *
     * @param token 网关验证用户的 token
     * @return 返回用户登录状态和用户信息
     */
    @GetMapping(value = "/getUserIdentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> getUserIdentity(@RequestHeader("Authorization") String token);

}
