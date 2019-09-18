package com.matthew.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.User;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.service
 * @CreateDate: 2019/9/3 14:08
 * @Version: 1.0
 */
public interface IUserService extends IService<User> {
    public IPage<User> findUserByPage(Page<User> page);
}
