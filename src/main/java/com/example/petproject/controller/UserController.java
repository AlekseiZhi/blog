package com.example.petproject.controller;

import com.example.petproject.model.User;
import com.example.petproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id") String id) {
        return userService.update(user, id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
}
