package org.teahel.annotion;

import java.lang.annotation.*;

/**
 * @Author L.T.J
 * @Date 2020/3/20 9:58
 * @Version 1.0
 *
 * 普通实体使用注解，管理该类到容器中。
 * 非Service controller dao层类使用。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
