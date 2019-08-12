package org.matthew.mvc;

import org.matthew.ioc.ApplicationContext;
import org.matthew.ioc.annotation.Autowire;
import org.matthew.ioc.annotation.Controller;
import org.matthew.ioc.support.AnnotationApplicationContext;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/13
 * Time: 9:28
 * Description: No Description
 */
@Controller
public class MyControllor {
 @Autowire("myservice")
 private MyService myService;

 public void test(){
     myService.say("hello word");
 }

 public static void main(String args[]){
     ApplicationContext context=new AnnotationApplicationContext("applicationContext.properties");
     MyControllor controllor=context.getBean("org.matthew.mvc.MyControllor",MyControllor.class);
     controllor.test();
 }
}
