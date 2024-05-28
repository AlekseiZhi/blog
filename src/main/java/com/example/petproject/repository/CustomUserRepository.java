package com.example.petproject.repository;

import com.example.petproject.model.User;

public interface CustomUserRepository {


    User save(User user);

    User getById(String id);

    User updateById(User user, String id);

    void deleteById(String id);
}
