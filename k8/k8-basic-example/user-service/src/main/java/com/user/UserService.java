package com.user;


import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class UserService {

    private static final Map<String, User> userRepo = new HashMap<>();

    static {
        userRepo.put("101", new User("101", "Alice Kumar", "alice@example.com"));
        userRepo.put("102", new User("102", "Ravi Singh", "ravi@example.com"));
    }

    public User getUserById(String id) {
        return userRepo.getOrDefault(id, new User(id, "Unknown User", "unknown@example.com"));
    }
}
