package com.example.petproject.repository;

import com.example.petproject.model.Post;

public interface CustomPostRepository {

    Post save(Post post);

    Post getById(String id);

    Post updateById(Post post, String id);

    void deleteById(String id);
}
