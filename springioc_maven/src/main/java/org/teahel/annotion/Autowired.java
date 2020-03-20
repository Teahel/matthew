package org.teahel.annotion;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author L.T.J
 * @Date 2020/3/19 9:36
 * @Version 1.0
 *
 * 实现其他已经存在注解的类。
 * 其他已经存在注解的类为service controller component等已经
 * 存在注解，统一在容器中管理。
 */
@Target({TYPE,FIELD,METHOD})
@Retention(RUNTIME)
@Component
public @interface Autowired {
}
