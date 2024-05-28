package com.example.petproject.repository;

import com.example.petproject.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>, CustomPostRepository {

}
