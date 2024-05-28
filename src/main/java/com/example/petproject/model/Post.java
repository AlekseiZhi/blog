package com.example.petproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document(collection = "posts")
public class Post {

    @MongoId
    private String id;
    private String title;
    private String content;
    @CreatedDate
    private LocalDate createDate;
    private String authorId;
    private List<String> tags;
    private List<byte[]> images;
}
