package cn.sunguolei.blog.noteservice.service;

import cn.sunguolei.blog.noteservice.domain.Note;

import java.util.List;

public interface NoteService {
    List<Note> index(int userId);
    
    int create(Note note);
}
