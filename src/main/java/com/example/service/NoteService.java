package com.example.service;

import com.example.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    public Note add(Note note){
        notes.add(note);
        return note;
    }

    public void deleteById(long id){
        for(Note note : notes) {
            if(note.getId() == id) {
                notes.remove(note);
                break;
            }
        }
    }

    public Note getById(long id){
        for(Note note : notes) {
            if(note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    public void update(Note note,String newTitle, String newContent) {
        note.setTitle(newTitle);
        note.setContent(newContent);
    }

    public List<Note> listAll(){
        return notes;
    }

}
