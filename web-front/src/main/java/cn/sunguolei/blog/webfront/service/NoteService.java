package cn.sunguolei.blog.webfront.service;

import cn.sunguolei.blog.webfront.domian.Note;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("zuul")
public interface NoteService {
    /**
     * 笔记列表页
     *
     * @param token  用户的 token
     * @param userId 用户 ID
     * @return 返回查到的笔记列表
     */
    @GetMapping(value = "/note/index", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Note> index(@RequestHeader("Authorization") String token, int userId);

    /**
     * 创建笔记
     *
     * @param note 要创建的笔记
     * @return 创建成功返回 1，失败返回 0
     */
    @PostMapping(value = "/note/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    int create(@RequestHeader("Authorization") String token, Note note);
}
