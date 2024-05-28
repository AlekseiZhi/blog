package com.example.petproject.repository;

import com.example.petproject.model.Reaction;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomReactionRepositoryImpl implements CustomReactionRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Reaction save(Reaction reaction) {
        return mongoTemplate.save(reaction);
    }

    @Override
    public Reaction getById(String id) {
        return mongoTemplate.findById(id, Reaction.class);
    }

    @Override
    public Reaction updateById(Reaction reaction, String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        if (reaction.getPostId() != null) update.set("postId", reaction.getPostId());
        if (reaction.getReactionType() != null) update.set("reactionType", reaction.getReactionType());
        if (reaction.getUserId() != null) update.set("userId", reaction.getUserId());
        FindAndModifyOptions findAndModifyOptions = FindAndModifyOptions.options().returnNew(true);
        return mongoTemplate.findAndModify(query, update, findAndModifyOptions, Reaction.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Reaction.class);
    }
}
