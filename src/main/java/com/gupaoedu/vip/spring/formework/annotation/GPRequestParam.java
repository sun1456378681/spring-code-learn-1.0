package com.gupaoedu.vip.spring.formework.annotation;

import java.lang.annotation.*;

/**
 * 请求url
 *
 * @author eric
 * @since 2020/12/6 14:42
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {
    String value() default "";
}
