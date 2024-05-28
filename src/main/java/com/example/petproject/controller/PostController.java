package com.example.petproject.controller;

import com.example.petproject.model.Post;
import com.example.petproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Post get(@PathVariable("id") String id) {
        return postService.get(id);
    }

    @PutMapping("/{id}")
    public Post update(@RequestBody Post post, @PathVariable("id") String id) {
        return postService.update(post, id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        postService.delete(id);
    }
}
