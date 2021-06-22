package com.nghiepvo.designpartten.cqrs.repositories;

import com.nghiepvo.designpartten.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserWriteRepository {

    private Map<String, User> userMap = new HashMap<>();

    public void addUser(String id, User user) {
        userMap.put(id, user);
    }

    public User getUser(String id) {
        return userMap.get(id);
    }
}
