package org.matthew.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:12
 * Description: No Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  //作用类上，
@Documented
public @interface Component {
    String value() default "";
}
