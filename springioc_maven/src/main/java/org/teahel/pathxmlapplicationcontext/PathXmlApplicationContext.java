package org.teahel.pathxmlapplicationcontext;

import org.teahel.annotion.Autowired;
import org.teahel.annotion.Component;
import org.teahel.annotion.Controller;
import org.teahel.annotion.Service;
import org.teahel.uitls.ClassParseUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author L.T.J
 * @Date 2020/3/19 10:29
 * @Version 1.0
 */
public class PathXmlApplicationContext {
    /**
     * 封装对象的容器
     */
    private ConcurrentHashMap<String,Object> beans = null;

    /**
     * 包名
     */
    private String packageName;

    public PathXmlApplicationContext(String packageName) throws Exception {
        beans=new ConcurrentHashMap<String, Object>();
        this.packageName = packageName;
        initBeans();
        initEntryField();
    }

    /**
     * 初始化bean的实例对象的所有属性
     */
    private void initEntryField() throws IllegalAccessException {
        /* 遍历所有得bean的容器对象 */
      for(Map.Entry<String,Object> entry : beans.entrySet()){
          /* 判断属性上面是否有加注解 */
       Object object = entry.getValue();
       attriAssign(object);
      }
    }

    /**
     * 依赖注入注解原理
     * @param object
     */
    private void attriAssign(Object object) throws IllegalAccessException {

        /**
         * 使用反射机制，获取当前类的所有属性
         */
        Class<? extends Object> classInfo = object.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();

        /**
         * 判断当前类属性是否存在注解
         */
        for(Field field : declaredFields){
            Autowired exAutowired = field.getAnnotation(Autowired.class);
            Component component = field.getAnnotation(Component.class);
            Controller controller = field.getAnnotation(Controller.class);

            /* 存在注解的属性，在容器中寻找该对象。*/
            if(exAutowired!=null||component!=null||controller!=null){
                String beanId = field.getName();
                Object bean = getBean(beanId);
                /* 在该类class中，给具有注解的属性，赋予(set)对象*/
                if(bean!=null){
                    /*允许私有属性*/
                    field.setAccessible(true);
                    field.set(object,bean);
                }
            }

        }

    }

    /**
     * 根据beanId在容器中获取对象
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        Object object = null;
        if(beanId!=null&&beanId!=""){
            try {
                object = beans.get(beanId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    /**
     * 初始化获取扫描包下面的所有bean(实体)
     */
    private void initBeans() throws Exception {
        /**
         * 使用java反射机制扫描包，获取当前包下所有的类。
         */
        List<Class<?>> classes = ClassParseUtil.getClasses(packageName);

        /**
         * 判断类是否有注解，如该类存在注解将添加到容器beans中
         */
        ConcurrentHashMap<String,Object> classExisAnnotation = findClassExistAnnotion(classes);
        if(classExisAnnotation.isEmpty()){
            throw new Exception("该包下没有任何类有注解");
        }

    }

    /**
     * 判断是否存在自定义的bean的注解
     * @param classes
     * @return
     */
    private ConcurrentHashMap<String, Object> findClassExistAnnotion(List<Class<?>> classes) throws Exception {
      for(Class<?> classInfo : classes){
          Service serviceAnnotation = classInfo.getAnnotation(Service.class);
          if(serviceAnnotation != null){
              String className = classInfo.getSimpleName();
              String beanId = toLowerCaseFirstOne(className);
              Object newInstance = newInstance(classInfo);
              beans.put(beanId,newInstance);
          }
      }
      return beans;
    }


    /**
     * 单词首字母转小写
     * @param className
     * @return
     */
    private String toLowerCaseFirstOne(String className) {
        if(Character.isLowerCase(className.charAt(0))) {
            return className;
        } else {
            return (new StringBuilder()).append((Character.toLowerCase(className.charAt(0)))).append(className.substring(1)).toString();
        }

    }

    /**
     * 根据class名称获取类的实例化对象
     * @param classInfo
     * @return
     * @throws Exception
     */
    private Object newInstance(Class<?> classInfo) throws Exception{
     return classInfo.newInstance();
    }




}
