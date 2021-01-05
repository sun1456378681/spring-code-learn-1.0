package com.gupaoedu.vip.spring.formework.annotation;

import java.lang.annotation.*;

/**
 * 请求url
 *
 * @author eric
 * @since 2020/12/6 14:42
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {
    String value() default "";
}
