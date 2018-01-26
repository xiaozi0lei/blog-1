package cn.sunguolei.blog.webfront.service;

import cn.sunguolei.blog.webfront.domian.Note;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("zuul")
@FeignClient("note")
public interface NoteService {
//    @GetMapping(value = "/note/index", consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/index", consumes = MediaType.APPLICATION_JSON_VALUE)
    String index();

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    int create(@RequestBody Note note);
}
