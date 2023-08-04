package com.example.controller;

import com.example.entity.Note;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public ModelAndView listNotes() {
        ModelAndView result = new ModelAndView("noteList");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam Long id) {
        ModelAndView result = new ModelAndView("redirect:/note/list");
        noteService.deleteById(id);
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView editNote(@RequestParam Long id) {
        ModelAndView result = new ModelAndView("noteEdit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView updateNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        ModelAndView result = new ModelAndView("redirect:/note/list");
        noteService.update(noteService.getById(id), title, content);
        return result;
    }

    @GetMapping("/create")
    public ModelAndView createNote() {
        ModelAndView result = new ModelAndView("noteCreate");
        return result;
    }

    @PostMapping("/create")
    public ModelAndView addNote(@RequestParam String title, @RequestParam String content) {
        ModelAndView result = new ModelAndView("redirect:/note/list");
        noteService.add(new Note(title, content));
        return result;
    }

}