package cn.sunguolei.blog.webfront.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("zuul")
public interface NoteService {
    @GetMapping(value = "/note/index", consumes = MediaType.APPLICATION_JSON_VALUE)
    String index();
}
