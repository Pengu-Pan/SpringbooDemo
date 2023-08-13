package example.controller;

import example.pojo.User;
import example.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userService.queryById(id);
    }

}
