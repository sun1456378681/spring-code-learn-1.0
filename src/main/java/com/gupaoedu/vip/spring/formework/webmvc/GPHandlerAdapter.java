package com.gupaoedu.vip.spring.formework.webmvc;

import com.gupaoedu.vip.spring.formework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The HandlerAdapter of native spring mainly completes the correspondence(对应关系，来往信件，通信) between
 * the parameter list passed to the server and the method argument list,
 * and completes the type conversion(转换) of parameter values
 * The core method is handle(). In the handle(), the tartget method is called by reflection(反射),
 * and the tranformation wrapped parameter list is passed
 * <p>
 * 原生Spring的HandlerAdapter 主要完成请求传递到服务端的参数列表与Method实参列表的对应关系，完成参数值的类型转换工作。
 * 核心方法是handle()，在handle() 方法中用反射来调用被适配的目标方法，并将转换包装好的参数列表传递过去
 *
 * @author eric
 * @since 2020/12/8 9:36
 */
public class GPHandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof GPHandlerMapping);
    }

    public GPModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        GPHandlerMapping handlerMapping = (GPHandlerMapping) handler;

        /**
         * everyMethod have one parameter list, here is a list of formal parameters (形参)
         */
        Map<String, Integer> paramMapping = new HashMap<String, Integer>();

        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof GPRequestParam) {
                    String paramName = ((GPRequestParam) a).value();
                    if (!"".equals(paramName.trim())) {
                        paramMapping.put(paramName, i);
                    }
                }
            }
        }

        /**
         * According to the parameter requested by user, it dynamically(动态地) matches with the parameters in method
         * Resp is passed in for only one purpose, copu it to the method parameter,that's it.
         *
         * Only when the ModelAndView passed by the user is empty,a default one will be created
         *
         * 1. Prepare a list of formal parameters for this method
         * The determinants(决定因素) of formal parameters when methods are overload: parameter number,parameter type, parameter order, method name
         * only handle(处理) Request and Response
         */
        Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> type = paramTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                paramMapping.put(type.getName(), i);
            }
        }

        /**
         * 2. get the location of the custom named parameter
         * The list of parameters passed by the user through the URL
         */
        Map<String, String[]> reqParameterMap = req.getParameterMap();

        /**
         * 3. Construct argument list
         */
        Object[] paramValues = new Object[paramTypes.length];

        for (Map.Entry<String, String[]> param : reqParameterMap.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll("\\s", "");
            if (paramMapping.containsKey(param.getKey())) {
                continue;
            }

            int index = paramMapping.get(param.getKey());

            /**
             * Because the values passed from the page are of String type, and the types defined in the method are various(多样的)
             * so we need to convert(转化) the type of parameters passed in
             */
            paramValues[index] = caseStringValue(value, paramTypes[index]);
        }

        if (paramMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = paramMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;
        }

        if (paramMapping.containsKey(HttpServletResponse.class.getName())) {
            int respIndex = paramMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = resp;
        }

        //4. get ‘Controller’ and ‘method’ from handler, then call it with reflection(反射)
        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);

        if (result == null) {
            return null;
        }

        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndView) {
            return (GPModelAndView) result;
        } else {
            return null;
        }
    }

    private Object caseStringValue(String value, Class<?> clazz) {
        if (clazz == String.class) {
            return value;
        } else if (clazz == Integer.class) {
            return Integer.valueOf(value);
        } else if (clazz == int.class) {
            return Integer.valueOf(value).intValue();
        }
        return null;
    }

}
