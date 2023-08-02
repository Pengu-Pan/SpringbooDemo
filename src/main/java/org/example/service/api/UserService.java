package org.example.service.api;

import org.example.dao.po.TbUserDo;
import org.example.pojo.User;

import java.util.List;

public interface UserService {
    List<User> searchUsersByName(String name);

    int add(String mobile, String name, String age);

    int update(String mobile, String name, String age);
}
