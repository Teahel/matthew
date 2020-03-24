package org.teahel.dao;

import org.teahel.annotion.Repository;
import org.teahel.entity.User;
import org.teahel.repository.HandlerRepository;

/**
 * @Author L.T.J
 * @Date 2020/3/24 17:32
 * @Version 1.0
 */
@Repository
public interface IUserDao extends HandlerRepository<User> {
}
