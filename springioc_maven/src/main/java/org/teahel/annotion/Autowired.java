package org.teahel.annotion;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author L.T.J
 * @Date 2020/3/19 9:36
 * @Version 1.0
 */
@Target({TYPE,FIELD,METHOD})
@Retention(RUNTIME)
public @interface Autowired {
}
