package org.matthew.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:13
 * Description: No Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//作用在字段上面
@Documented
public @interface Autowire {
    String value() default "";
}
