package cn.sunguolei.blog.noteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/test")
    public String test1() {
        return "note test";
    }
}
