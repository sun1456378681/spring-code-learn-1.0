package com.gupaoedu.vip.spring.formework.core;

/**
 * 单例工厂的顶层设计
 *
 * @author eric
 * @since 2020/12/6 14:46
 */
public interface GPBeanFactory {
    /**
     * 根据beanName从IOC容器中获得一个实例bean
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    Object getBean(String beanName) throws Exception;

    /**
     * 根据class类型
     *
     * @param beanClass
     * @return
     * @throws Exception
     */
    public Object getBean(Class<?> beanClass) throws Exception;
}
