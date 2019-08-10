package org.matthew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Matthew
 * @Date: 2019/8/10
 * @Time: 13:43
 * @Description: 一个简单的springboot开始例子
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {

    @Value("${my.name}")
    String name;
    @Value("${my.age}")
    String age;

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/hi")
    public String index(){
        return "Welcome to this world!"+name +"  "+age;
    }

    @RequestMapping("/print")
    public String show(){
        return configBean.getName()+" "+configBean.getPrint()+" "+configBean.getUuid();
    }
}
