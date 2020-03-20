package org.teahel.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * @Author L.T.J
 * @Date 2020/3/20 10:05
 * @Version 1.0
 *
 * 使用在controller层
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
@Component
public @interface Controller {
}
