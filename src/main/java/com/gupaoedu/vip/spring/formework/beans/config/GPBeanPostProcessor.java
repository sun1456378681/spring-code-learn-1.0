package com.gupaoedu.vip.spring.formework.beans.config;

/**
 * 原生Spring中的BeanPostProcessor 是为对象初始化事件设置的一种回调机制。此版本只做说明，不做具体实现
 *
 * @author eric
 * @since 2020/12/7 9:28
 */
public class GPBeanPostProcessor {

    /**
     * 在bean的初始化之前提供回调入口
     *
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object postProcessBeforInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    /**
     * 在bean的初始化之后提供回调入口
     *
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
