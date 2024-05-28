package com.example.petproject.service;

import com.example.petproject.model.Reaction;
import com.example.petproject.repository.CustomReactionRepository;
import com.example.petproject.repository.CustomReactionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactionService {

    private final CustomReactionRepositoryImpl customReactionRepository;

    public Reaction get(String id) {
        return customReactionRepository.getById(id);
    }

    public Reaction update(Reaction user, String id) {
        return customReactionRepository.updateById(user, id);
    }

    public Reaction save(Reaction user) {
        return customReactionRepository.save(user);
    }

    public void delete(String id) {
        customReactionRepository.deleteById(id);
    }

}

