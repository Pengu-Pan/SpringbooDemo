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

    @GetMapping("/search")
    public Result printInfo(@RequestBody User user){
        log.info("查询用户信息，输入：{}",user.getName());
        List<User> users=userService.searchUsersByName(user.getName());
        log.info("查询用户结果，输出：{}",users);

        if(users.isEmpty()){
            return new Result(ReturnCode.FAIL);
        }
        return new Result(ReturnCode.SUCCESS,users);
    }

    @GetMapping("/add")
    public Result addUser(@RequestBody User user){
        log.info("插入用户，输入：{}",user);
        int returnNum;
        returnNum=userService.add(user.getMobile(),user.getName(),user.getAge());
        log.info("插入返回结果，输出：{}",returnNum);

        if(returnNum == 0){
            return new Result(ReturnCode.SUCCESS);
        }
        return new Result(ReturnCode.FAIL);
    }

    @GetMapping("/update")
    public Result update(@RequestBody User user){
        log.info("更新用户信息，输入：{}",user);
        int returnNum;
        returnNum=userService.update(user.getMobile(),user.getName(),user.getAge());
        log.info("更新返回结果，输出：{}",returnNum);

        if(returnNum == 0){
            return new Result(ReturnCode.SUCCESS);
        }
        return new Result(ReturnCode.FAIL);
    }

}
