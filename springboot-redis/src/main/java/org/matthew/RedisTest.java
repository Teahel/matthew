package org.matthew;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Matthew
 * @Date: 2019/8/11
 * @Time: 11:06
 * @Description: 测试类
 */
@RestController
public class RedisTest {
    @Autowired
    private RedisDao redisDao;

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    public String testReids(){
        redisDao.setKey("name","matthew");
        redisDao.setKey("age","11");
        return redisDao.getValue("name")+"  "+redisDao.getValue("age");
    }
}
