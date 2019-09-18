package com.matthew.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matthew.entity.User;
import com.matthew.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.controller
 * @CreateDate: 2019/9/4 9:01
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserServicel;

    @RequestMapping("/page")
    public IPage findUserByPage(int pageNo , int pageSize){
        Page<User> page=new Page<>(pageNo,pageSize);//第几页 ，每页大小
        return iUserServicel.findUserByPage(page);
    }
}
