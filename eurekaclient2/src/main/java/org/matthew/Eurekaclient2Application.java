package org.matthew;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Matthew
 * @Date: 2019/8/8
 * @Time: 21:54
 * @Description: 消费者2
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Eurekaclient2Application {
    public static void main(String []args){
      SpringApplication.run(Eurekaclient2Application.class,args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public  String home(@RequestParam(value = "name",defaultValue = "foezp") String name){
        return "hi  " +name+",I am mattew!:"+port;
    }
}
