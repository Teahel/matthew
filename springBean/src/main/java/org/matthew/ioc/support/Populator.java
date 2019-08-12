package org.matthew.ioc.support;

import org.matthew.ioc.annotation.Autowire;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/12
 * Time: 0:58
 * Description: No Description
 */
public class Populator {
    public Populator(){
    }

    public void populate(Map<String,Object> instanceMapping){
        //首先要判断ioc容器中有没有东西
        if(instanceMapping.isEmpty())return;

        //循环遍历每一个容器中得对象
        for (Map.Entry<String,Object> entry:instanceMapping.entrySet()){
            //获取对象的字段
            Field[] fields = entry.getValue().getClass().getDeclaredFields();//getDeclaredFields() 获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段
            for (Field field:fields){
                if(!field.isAnnotationPresent(Autowire.class))continue;//只处理Autowire注解
                Autowire autowire = field.getAnnotation(Autowire.class);//获取该字段的Autowire对象
                //后去字段要注入的id value  为空则按类名  接口名自动注入
                String id = autowire.value();//如果是没有注解值，那么赋值字段的getName()，如果不为空，则id的值为注解的值
                if("".equals(id))id = field.getType().getName();//该的名称
                field.setAccessible(true);//在其他类里获取该类的私有成员变量时，需要设置访问标志为true，否则会报异常
                try {
                    //反射注入
                    field.set(entry.getValue(),instanceMapping.get(id));//上面获取的所有的entry的字段，循环之后，反射对应对象的字段。
                    //instanceMapping.get(id)中value(BeanDefinition)的对象的每个字段赋值给entry.getValue()对象中。
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
