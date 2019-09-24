package com.matthew.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.Utils.MD5Utils;
import com.matthew.entity.User;
import com.matthew.mapper.UserMapper;
import com.matthew.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/19 17:22
 * @Version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    /**
     * 登陆
     * @param username 账户
     * @param password 密码
     * @return 若无该账户则返回 null
     *         若存在该账户则返回 true
     */
    @Override
    public User login(String username, String password) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",username);
        User user=this.baseMapper.selectOne(queryWrapper);
        if (StringUtils.isEmpty(user)) {
            return null;
        }
        //md5解密
        if(MD5Utils.md5(password,user.getPassword())){
            return  user;
        }
        return null;
    }
}
