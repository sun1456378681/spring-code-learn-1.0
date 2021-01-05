package com.gupaoedu.vip.spring.formework.annotation;

import java.lang.annotation.*;

/**
 * 业务逻辑，注入接口
 *
 * @author eric
 * @since 2020/12/6 14:37
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPService {
    String value() default "";
}
