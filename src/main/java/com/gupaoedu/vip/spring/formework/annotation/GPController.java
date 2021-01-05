package com.gupaoedu.vip.spring.formework.annotation;

import java.lang.annotation.*;

/**
 * 页面交互
 *
 * @author eric
 * @since 2020/12/6 14:42
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPController {
    String value() default "";
}
