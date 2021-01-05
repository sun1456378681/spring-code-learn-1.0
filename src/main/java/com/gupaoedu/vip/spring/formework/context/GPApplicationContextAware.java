package com.gupaoedu.vip.spring.formework.context;

/**
 * 通过解耦方式获得IoC容器的顶层设计
 * 后面将通过一个监听器去扫描所有的类。只要实现了此接口，
 * 将自动调用setApplicationContext()方法，从而将IoC容器注入目标类中
 *
 * @author eric
 * @since 2020/12/6 16:14
 */
public interface GPApplicationContextAware {
    /**
     * set
     *
     * @param applicationContext
     */
    void setApplicationContext(GPApplicationContext applicationContext);
}
