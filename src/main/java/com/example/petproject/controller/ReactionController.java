package com.example.petproject.controller;

import com.example.petproject.model.Reaction;
import com.example.petproject.model.User;
import com.example.petproject.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reactions")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

    @GetMapping("/{id}")
    public Reaction get(@PathVariable("id") String id) {
        return reactionService.get(id);
    }

    @PutMapping("/{id}")
    public Reaction update(@RequestBody Reaction reaction, @PathVariable("id") String id) {
        return reactionService.update(reaction, id);
    }

    @PostMapping
    public Reaction save(@RequestBody Reaction reaction) {
        return reactionService.save(reaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        reactionService.delete(id);
    }
}
