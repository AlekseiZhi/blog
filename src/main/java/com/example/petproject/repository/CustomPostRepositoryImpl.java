package com.example.petproject.repository;

import com.example.petproject.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Post save(Post post) {
        return mongoTemplate.save(post);
    }

    @Override
    public Post getById(String id) {
        return mongoTemplate.findById(id, Post.class);
    }

    @Override
    public Post updateById(Post post, String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        if (post.getAuthorId() != null) update.set("authorId", post.getAuthorId());
        if (post.getTitle() != null) update.set("title", post.getTitle());
        if (post.getTags() != null) update.set("tags", post.getTags());
        if (post.getContent() != null) update.set("content", post.getContent());
        if (post.getImages() != null) update.set("images", post.getImages());
        FindAndModifyOptions findAndModifyOptions = FindAndModifyOptions.options().returnNew(true);
        return mongoTemplate.findAndModify(query, update, findAndModifyOptions, Post.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Post.class);
    }
}
