package org.matthew.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:15
 * Description: No Description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})//作用在方法的类型
public @interface RequestMapping {
    String value() default "";
}
