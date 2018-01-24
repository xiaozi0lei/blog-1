package cn.sunguolei.blog.servicezuul.service;


import cn.sunguolei.blog.servicezuul.domain.ApplicationUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user")
public interface UserService {

    @GetMapping(value = "/findUserByUsername", consumes = MediaType.APPLICATION_JSON_VALUE)
    ApplicationUser findUserByUsername(@RequestParam("username") String username);

}
