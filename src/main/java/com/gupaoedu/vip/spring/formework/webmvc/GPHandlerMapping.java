package com.gupaoedu.vip.spring.formework.webmvc;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * xx类
 *
 * @author eric
 * @since 2020/12/8 9:25
 */
public class GPHandlerMapping {
    /**
     * 目标方法所在的controller 对象
     */
    private Object controller;
    /**
     * URL 对应的目标方法
     */
    private Method method;
    /**
     * URL 的封装
     */
    private Pattern pattern;

    public GPHandlerMapping(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
