package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.common.response.Result;
import org.example.common.response.ReturnCode;
import org.example.pojo.User;
import org.example.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/search")
    public Result printInfo(@RequestBody User user){
        log.info("查询用户信息，输入：{}",user);
        List<User> users=userService.searchUsersByName(user.getName());
        log.info("查询用户结果，输出：{}",users);

        if(users.isEmpty()){
            return new Result(ReturnCode.FAIL);
        }
        return new Result(ReturnCode.SUCCESS,users);
    }
}
