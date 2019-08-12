package org.matthew.ioc.support;

import org.matthew.ioc.BeanRegister;

import java.util.List;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/12
 * Time: 0:57
 * Description: No Description
 */
public class BeanCreater {
    private BeanRegister register;
    public BeanCreater(BeanRegister register){
        this.register = register;
    }

    public void create(List<BeanDefinition> bds){
        for (BeanDefinition bd:bds){
            doCreate(bd);
        }
    }

    private void doCreate(BeanDefinition bd) {
        Object instance = bd.getInstance();//创建新的对象，只能调用无参构造 newInstance()：bd.getId()为注解的value(值)如：MySerivce
        this.register.registInstanceMapping(bd.getId(),instance);
    }
}
