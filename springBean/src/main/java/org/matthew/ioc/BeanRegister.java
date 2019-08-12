package org.matthew.ioc;

import org.matthew.ioc.support.BeanDefinition;

import java.util.List;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:08
 * Description: No Description
 */
public interface BeanRegister {
    /**
     * 向工厂内注册BeanDefinition
     * @param bds
     */
    void registBeanDefinition(List<BeanDefinition> bds);

    /**
     * 向工厂内注册bean实例对象
     * @param id
     * @param instance
     */
    void registInstanceMapping(String id,Object instance);
}
