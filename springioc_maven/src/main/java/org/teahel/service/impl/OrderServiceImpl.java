package org.teahel.service.impl;

import org.teahel.annotion.Service;
import org.teahel.service.IOrderService;

/**
 * @Author L.T.J
 * @Date 2020/3/19 16:32
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {


    public String printSomething(){

      return "测试";
    }
}
