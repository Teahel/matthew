package com.matthew.controller;

import com.matthew.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.controller
 * @CreateDate: 2019/9/19 17:44
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        User loginUser = new User();

        return loginUser;
    }
}
