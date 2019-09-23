package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.User;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service
 * @CreateDate: 2019/9/19 17:22
 * @Version: 1.0
 */
public interface UserService extends IService<User> {

    /**
     * 登陆
     * @param username 账户
     * @param password 密码
     * @return 若无该账户则返回 null
     *         若存在该账户则返回 true
     */
     User login(String username,String password);

}
