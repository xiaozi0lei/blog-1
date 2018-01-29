package cn.sunguolei.blog.webfront.service;

import cn.sunguolei.blog.webfront.domian.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("zuul")
public interface UserService {
    /**
     * 根据用户名查找用户
     *
     * @param token    用户的 token
     * @param username 要查找的用户名
     * @return 返回查询到的用户
     */
    @GetMapping(value = "/user/findUserByUsername", consumes = MediaType.APPLICATION_JSON_VALUE)
    User findUserByUsername(@RequestHeader("Authorization") String token, String username);
}
