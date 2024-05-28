package com.example.petproject.service;

import com.example.petproject.model.Post;
import com.example.petproject.repository.CustomPostRepository;
import com.example.petproject.repository.CustomPostRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CustomPostRepositoryImpl customPostRepository;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public Post get(String id) {
        return customPostRepository.getById(id);
    }

    public Post update(Post post, String id) {
        return customPostRepository.updateById(post, id);
    }

    public Post save(Post post) {
        return customPostRepository.save(post);
    }

    public void delete(String id) {
        customPostRepository.deleteById(id);
    }

}

