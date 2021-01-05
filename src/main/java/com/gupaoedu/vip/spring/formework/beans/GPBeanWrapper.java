package com.gupaoedu.vip.spring.formework.beans;

/**
 * 主要用于封装创建后的对象实例，代理对象（Proxy Object）或者原生对象（Original Object）都由BeanWrapper来保存。
 *
 * @author eric
 * @since 2020/12/6 14:53
 */
public class GPBeanWrapper {
    private Object wrappedInstance;

    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance() {
        return wrappedInstance;
    }

    /**
     * 返回代理后的class
     * 可能会是这个$Proxy0
     *
     * @return
     */
    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }


}
