package org.matthew.mvc;

import org.matthew.ioc.annotation.Component;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/13
 * Time: 9:30
 * Description: No Description
 */
@Component("myservice")
public class  MyService {
 public void say(String s){
     System.out.println(s);
 }
}
