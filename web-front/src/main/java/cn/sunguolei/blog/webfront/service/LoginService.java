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

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    String loginTest(@RequestBody Map<String, String> map);

    @GetMapping(value = "/user/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    String testUser(@RequestHeader("Authorization") String token);

    @GetMapping(value = "/note/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    String testNote(@RequestHeader("Authorization") String token);
}
