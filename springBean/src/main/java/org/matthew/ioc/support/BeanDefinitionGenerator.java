package org.matthew.ioc.support;

import org.matthew.ioc.annotation.Component;
import org.matthew.ioc.annotation.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/12
 * Time: 0:56
 * Description: No Description
 */
public class BeanDefinitionGenerator {
    public static List<BeanDefinition> generate(String className){
        try {
            //Class.forName("类名字符串")  （注：类名字符串是包名+类名）  说明：装入类,并做类的静态初始化，返回Class的对象
            Class clazz = Class.forName(className);//运行时，加载此类（className）
            String[] ids = generateIds(clazz);//ids 注解的value或者接口名
            if(ids==null)return null;
            List<BeanDefinition> list = new ArrayList<BeanDefinition>();
            for (String id:ids){
                list.add(new BeanDefinition(id,clazz));//注解值，类
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成id数组
     * 1.带有@Controller 注解但是注解value没给值,@Controller一般没有
     * 接口定义,用类的全名作为id 返回ids长度为1
     * 2.@Component 没有value  获取所有的实现的接口,接口名为id,返货ids数组
     * 长度是实现的接口个数
     * 3.@Component 有value 返回id=value
     * 4.不带容器要实例化的注解  null
     */
    private static String[] generateIds(Class clazz) {
        String[] ids = null;
        if (clazz.isAnnotationPresent(Controller.class)) {//clazz.isAnnotationPresent(Component.class) 引用了Component就会返回true
            ids = new String[]{
                    clazz.getName()
            };
        } else if (clazz.isAnnotationPresent(Component.class)) {
            Component component = (Component) clazz.getAnnotation(Component.class);
            String value = component.value();//获取注解的值 这里是"myservice" 在service中添加了此注解
            if (!"".equals(value)) {
                ids = new String[]{value};
            } else {
                Class<?>[] interfaces = clazz.getInterfaces();//获取所有的接口
                ids = new String[interfaces.length];
                //如果这个类实现了接口，就用接口的类型作为id
                for (int i = 0; i < interfaces.length; i++){
                    ids[i] = interfaces[i].getName();
                }
                return ids;
            }
        }
        return ids;
    }
}
