package org.example.service.api;

import org.example.pojo.User;

import java.util.List;

public interface UserService {
    List<User> searchUsersByName(String name);
}
