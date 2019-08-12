package org.matthew.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/11
 * Time: 23:16
 * Description: No Description
 */
@Target(ElementType.PARAMETER)//作用在方法的参数上面
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {
    String value() default "";
}
