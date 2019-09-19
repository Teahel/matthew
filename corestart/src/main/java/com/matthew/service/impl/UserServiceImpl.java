package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.User;
import com.matthew.mapper.UserMapper;
import com.matthew.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/19 17:22
 * @Version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
