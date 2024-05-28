package com.example.petproject.repository;

import com.example.petproject.model.Reaction;
import com.example.petproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public User getById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public User updateById(User user, String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        if (user.getEmail() != null) update.set("email", user.getEmail());
        if (user.getName() != null) update.set("name", user.getName());
        if (user.getPassword() != null) update.set("password", user.getPassword());
        FindAndModifyOptions findAndModifyOptions = FindAndModifyOptions.options().returnNew(true);
        return mongoTemplate.findAndModify(query, update, findAndModifyOptions, User.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
