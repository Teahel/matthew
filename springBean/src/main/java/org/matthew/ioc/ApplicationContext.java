package org.matthew.ioc;

import java.util.Map;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:06
 * Description: No Description
 */
public interface ApplicationContext {
    /**
     * 根据id获取bean
     * @param id
     * @return
     */
    Object getBean(String id);

    /**
     * 根据id获取特定类型的bean,完成强转
     * @param id
     * @param clazz
     * @param <T>
     * @return
     */
    <T>T getBean(String id,Class<T> clazz);

    /**
     * 获取工厂内的所有bean集合
     * @return
     */
    Map<String,Object> getBeans();

}

