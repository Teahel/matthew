package org.matthew.ioc.support;

import org.matthew.ioc.BeanRegister;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:32
 * Description: No Description
 */
public class BeanDefinitionParser {
    //配置的扫描包的key
    public static final String SCAN_PACKAGE="SCAN_PACKAGE";

    //容器的注册对象
    private BeanRegister register;
    public BeanDefinitionParser(BeanRegister register){
        this.register=register;
    }
    public void parse(Properties properties){
        //获取要扫描的包
        String packageName=properties.getProperty(SCAN_PACKAGE);

        //执行注册
        doRegister(packageName);
    }

    public void doRegister(String packageName){
        try{
            //获取此包名下的绝对路径
            URL url=getClass().getClassLoader().getResource(packageName.replaceAll("\\.","/"));
            File dir=new File(url.getFile());
            //循环遍历 递归找到所有的java文件
            for(File file:dir.listFiles()){
                if(file.isDirectory()){
                    //文件夹--》递归继续执行9
                    doRegister(packageName+"."+file.getName());
                }else{
                    //处理文件名来获取类名，运动时，获取到的是class文件
                   // String className=packageName+"."+file.getName().replaceAll(".class","").trim();//TODO
                    String className=file.getAbsolutePath().replaceAll(".class","").trim();//TODO
                    //调用BeanDefinition Generaror,generate(className)方法，来处理
                    //1、类带有容器要处理的注解，则解析id生成，BeanDefinition集合返回
                    //2、不带有需要处理的注解， 直接返回null
                    List<BeanDefinition> definitions = BeanDefinitionGenerator.generate(className);//返回带有id 和clazz实体list
                    if(definitions == null)continue;
                    //调用容器的注册方法来完成bean信息的注册
                    this.register.registBeanDefinition(definitions);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
