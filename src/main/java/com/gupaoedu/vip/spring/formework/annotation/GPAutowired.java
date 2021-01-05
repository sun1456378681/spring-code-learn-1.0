package com.gupaoedu.vip.spring.formework.annotation;

import java.lang.annotation.*;

/**
 * 接口注入
 *
 * @author eric
 * @since 2020/12/6 14:42
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
    String value() default "";
}
