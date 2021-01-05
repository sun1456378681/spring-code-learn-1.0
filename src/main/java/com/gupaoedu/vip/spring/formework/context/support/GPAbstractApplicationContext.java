package com.gupaoedu.vip.spring.formework.context.support;

/**
 * IOC容器实现的顶层设计，实现IoC容器相关的公共逻辑。
 *
 * @author eric
 * @since 2020/12/6 15:01
 */
public class GPAbstractApplicationContext {

    /**
     * 受保护，只提供给子类重写
     *
     * @throws Exception
     */
    public void refresh() throws Exception {
    }
}
