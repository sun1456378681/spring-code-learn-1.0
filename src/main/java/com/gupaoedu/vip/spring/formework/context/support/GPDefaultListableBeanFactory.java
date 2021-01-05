package com.gupaoedu.vip.spring.formework.context.support;

import com.gupaoedu.vip.spring.formework.beans.config.GPBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 是众多IoC容器子类的典型代表。定义顶层的IoC缓存，也就是一个Map，属性名字也和原生Spring保持一致，定义为
 *
 * @author eric
 * @since 2020/12/6 15:03
 */
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    /**
     * 存储注册信息的BeanDefinition
     */
    protected final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, GPBeanDefinition>();
}
