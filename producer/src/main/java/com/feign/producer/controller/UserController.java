package com.feign.producer.controller;

import com.feign.producer.dto.Response;
import com.feign.producer.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/v1/")
public class UserController {

    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    @PostMapping("user")
    public User addUser(@RequestBody User incomingUserRequest) {
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setUserId(userId);
        user.setFirstName(incomingUserRequest.getFirstName());
        user.setLastName(incomingUserRequest.getLastName());
        user.setEmail(incomingUserRequest.getEmail());
        user.setMobileNo(incomingUserRequest.getMobileNo());
        users.put(userId, user);
        return user;
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return users.get(UUID.fromString(id));
    }

}
