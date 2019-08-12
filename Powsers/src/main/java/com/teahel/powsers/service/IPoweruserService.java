package com.teahel.powsers.service;

import com.teahel.powsers.beans.Poweruser;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/2
 * Time: 23:36
 * Description: No Description
 */
public interface IPoweruserService {
    Poweruser findById(long id);
    /**
     * 用户登录
     * @param username 账户
     * @param password 密码
     * @return 用户实体
     */
   public Poweruser findByUsernameAndPassword(String username,String password);
}
