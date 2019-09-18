package com.matthew.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.User;
import com.matthew.mapper.UserMapper;
import com.matthew.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/3 14:08
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Override
    public IPage<User> findUserByPage(Page<User> page) {
        return baseMapper.selectPage(page,null);
    }
}
