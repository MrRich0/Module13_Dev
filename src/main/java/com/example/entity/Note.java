package com.example.entity;

import com.example.service.RandomIdGenerator;
import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = new RandomIdGenerator().generate();
        this.title = title;
        this.content = content;
    }
}
