package com.teahel.powsers.repository;

import com.teahel.powsers.beans.Poweruser;
import com.teahel.powsers.beans.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/2
 * Time: 23:29
 * Description: No Description
 */
public interface PoweruserRepository extends JpaRepository<Poweruser, Long> {
    /**
     * 根据id 查询对象
      * @param id
     * @return
     */
    Poweruser findById(long id);

    /**
     * 用户登录
     * @param username 账户
     * @param password 密码
     * @return 用户实体
     */
    Poweruser findByUsernameAndPassword(String username,String password);
}
