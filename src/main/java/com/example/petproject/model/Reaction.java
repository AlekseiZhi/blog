package com.example.petproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document(collection = "reactions")
public class Reaction {

    @MongoId
    private String id;
    private String postId;
    private String userId;
    private ReactionType reactionType;

    public enum ReactionType{
        LIKE,DISLIKE,LOVE,HAHA,WOW,SAD,ANGRY
    }
}
