package com.example.petproject.repository;

import com.example.petproject.model.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReactionRepository extends MongoRepository<Reaction, String>, CustomReactionRepository {
}
