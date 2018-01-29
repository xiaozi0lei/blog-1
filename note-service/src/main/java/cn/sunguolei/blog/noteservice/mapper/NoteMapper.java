package cn.sunguolei.blog.noteservice.mapper;

import cn.sunguolei.blog.noteservice.domain.Note;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    List<Note> index(int userId);

    int create(Note note);
}
