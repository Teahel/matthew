package org.matthew.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:10
 * Description: No Description
 */

@Documented
@Target(ElementType.TYPE)//作用在类上面 一般在Controller
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface Controller {
    String value() default "";
}
