package com.muffincrunchy.marketplace.controller;

import com.muffincrunchy.marketplace.model.constant.ApiUrl;
import com.muffincrunchy.marketplace.model.dto.request.UserRequest;
import com.muffincrunchy.marketplace.model.entity.User;
import com.muffincrunchy.marketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiUrl.USER_URL)
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(ApiUrl.ID_PATH)
    public User getUser(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserRequest user) {
        return userService.create(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(ApiUrl.ID_PATH)
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
