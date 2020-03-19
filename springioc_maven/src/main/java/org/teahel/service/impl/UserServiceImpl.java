package org.teahel.service.impl;

import org.teahel.annotion.Autowired;
import org.teahel.annotion.Service;
import org.teahel.service.IOrderService;
import org.teahel.service.IUserService;

/**
 * @Author L.T.J
 * @Date 2020/3/19 16:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IOrderService orderServiceImpl;

    /**
     * 输出测试
     * @return
     */
    public String outPut(){
        String ss = orderServiceImpl.printSomething();
        return ss;
    }

}
