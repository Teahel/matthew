package org.teahel.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author L.T.J
 * @Date 2020/3/19 9:11
 * @Version 1.0
 *
 * 在服务层，将添加注解的对象添加入容器中
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Service {
}
