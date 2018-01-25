package cn.sunguolei.blog.noteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/index")
    public String index() {
        return "note test";
    }
}
