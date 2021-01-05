package com.gupaoedu.vip.spring.formework.webmvc;

import java.util.Map;

/**
 * ModelAndView in native Spring mainly used to encapsulate(封装压缩) the page template and corresponding(对应关系)
 * relationship of parameters to be transmitted(传递，传输) to the page
 * <p>
 * 原生Spring中 ModelAndView 类主要用于封装页面模板和要往页面传送的参数的对应关系
 *
 * @author eric
 * @since 2020/12/8 9:52
 */
public class GPModelAndView {

    /**
     * The name of page template
     */
    private String viewName;

    /**
     * Parameters transmit to page
     */
    private Map<String, ?> model;

    public GPModelAndView(Map<String, ?> model) {
        this.model = model;
    }

    public GPModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
