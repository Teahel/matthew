package org.teahel.service.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.teahel.annotion.Autowired;
import org.teahel.annotion.Service;
import org.teahel.dao.IUserDao;
import org.teahel.entity.User;
import org.teahel.service.IOrderService;
import org.teahel.service.IUserService;

import java.sql.SQLException;

/**
 * @Author L.T.J
 * @Date 2020/3/19 16:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService{

   /* @Autowired
    private IOrderService orderServiceImpl;*/

    @Autowired
    private IUserDao iUserDao;


    /**
     * 输出测试
     * @return
     */
    public User outPut() throws SQLException {
/*
        String ss = orderServiceImpl.printSomething();
*/
        User user = iUserDao.query(new BeanHandler<User>(User.class));
        return user;
    }

}
