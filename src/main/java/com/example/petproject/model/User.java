package com.example.petproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @MongoId
    private String id;
    private String name;
    private String email;
    private String password;
    @CreatedDate
    private LocalDateTime createDate;
}