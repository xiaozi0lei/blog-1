package cn.sunguolei.blog.noteservice.controller;

import cn.sunguolei.blog.noteservice.domain.Note;
import cn.sunguolei.blog.noteservice.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private static Logger logger = LoggerFactory.getLogger(NoteController.class);

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/index")
    public List<Note> index() {
        return noteService.index();
    }

    @PostMapping("/create")
    public int create(@RequestBody Note note) {

        logger.debug("helo, I am waiting for breakpoint");
        return noteService.create(note);
    }

    @Value("${spring.datasource.url}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }
}
