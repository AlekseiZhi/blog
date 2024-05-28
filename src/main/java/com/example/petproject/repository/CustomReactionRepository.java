package com.example.petproject.repository;

import com.example.petproject.model.Reaction;

public interface CustomReactionRepository {

    Reaction save(Reaction post);

    Reaction getById(String id);

    Reaction updateById(Reaction post, String id);

    void deleteById(String id);
}
