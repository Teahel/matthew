package org.teahel;

import org.teahel.pathxmlapplicationcontext.PathXmlApplicationContext;
import org.teahel.service.impl.UserServiceImpl;

/**
 * @Author L.T.J
 * @Date 2020/3/19 16:38
 * @Version 1.0
 */
public class Test {

    public static void main(String args[]) throws Exception {
        PathXmlApplicationContext pathXmlApplicationContext = new PathXmlApplicationContext("org.teahel.service.impl");
        UserServiceImpl userService = (UserServiceImpl)pathXmlApplicationContext.getBean("userServiceImpl");
        String result = userService.outPut();
        System.out.println("orderservice输出:"+result);
        System.out.println("对象:"+userService);
    }
}
