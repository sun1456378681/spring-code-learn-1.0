package com.gupaoedu.vip.spring.formework.beans.config;

/**
 * 用来存储配置文件中的信息
 * 相当于保存在内存中的位置
 *
 * @author eric
 * @since 2020/12/6 14:49
 */
public class GPBeanDefinition {
    /**
     * 原生bean的全类名
     */
    private String beanClassName;

    /**
     * 标记是否延迟加载
     */
    private boolean lazyInit = false;

    /**
     * 保存beanName，在IOC容器中存储的key
     */
    private String factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
