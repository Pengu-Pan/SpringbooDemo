package example.service.api;

import example.pojo.User;

import java.util.List;

public interface UserOprService {
    List<User> searchUsersByName(String name);

    int add(String mobile, String name, String age);

    int update(String mobile, String name, String age);


}
