package cn.sunguolei.blog.webfront.controller;

import cn.sunguolei.blog.webfront.domian.Note;
import cn.sunguolei.blog.webfront.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/index")
    public String index() {
        return noteService.index();
    }

    @GetMapping("/add")
    public String add() {
        return "note/add";
    }

    @PostMapping("/create")
    public String create(Note note) {

        LocalDateTime createTime = LocalDateTime.now();
        note.setCreateTime(createTime);
        note.setUserId(1);
        int number = noteService.create(note);

        return "redirect:/note/index";
    }

}
