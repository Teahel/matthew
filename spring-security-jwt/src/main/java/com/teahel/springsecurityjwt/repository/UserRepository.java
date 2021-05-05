package com.teahel.springsecurityjwt.repository;

import com.teahel.springsecurityjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据用户查询信息
     * @param username 用户名
     * @return 查询结果
     */
    User findByUsername(String username);
}
