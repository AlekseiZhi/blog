package com.example.petproject.service;

import com.example.petproject.model.User;
import com.example.petproject.repository.CustomUserRepository;
import com.example.petproject.repository.CustomUserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomUserRepositoryImpl customUserRepository;

    public User get(String id){
        return customUserRepository.getById(id);
    }

    public User update(User user, String id){
        return customUserRepository.updateById(user, id);
    }

    public User save(User user){
        return customUserRepository.save(user);
    }

    public void delete(String id){
        customUserRepository.deleteById(id);
    }

}

