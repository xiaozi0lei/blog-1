package cn.sunguolei.blog.noteservice.service.Impl;

import cn.sunguolei.blog.noteservice.domain.Note;
import cn.sunguolei.blog.noteservice.mapper.NoteMapper;
import cn.sunguolei.blog.noteservice.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteMapper noteMapper;

    public NoteServiceImpl(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Note> index() {
        return noteMapper.index();
    }

    @Override
    public int create(Note note) {
        return noteMapper.create(note);
    }
}
