package com.gupaoedu.vip.spring.formework.webmvc;

import java.io.File;

/**
 * 原生Spring 中的 ViewResolver 主要完成模板名称和模板引擎的匹配。通过在Servlet中调用resolveViewName() 方法来获得模板所对应的View。
 * <p>
 * 设计这个类主要目的是：
 * 1. 将一个静态文件变为一个动态文件
 * 2. 根据用户传送不同的参数，产生不同的结果
 * 3. 最终输出字符串，交给Response输出
 *
 * @author eric
 * @since 2020/12/8 11:39
 */
public class GPViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private File templateRootDir;

    private String viewName;

    public GPViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        this.templateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName
}
