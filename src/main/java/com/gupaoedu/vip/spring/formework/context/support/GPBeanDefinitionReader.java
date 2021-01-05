package com.gupaoedu.vip.spring.formework.context.support;

import com.gupaoedu.vip.spring.formework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 主要完成对 application.properties配置文件的解析工作，实现逻辑非常简单。
 * 通过构造方法获取从ApplicationContext传过来的locations配置文件路径
 * 然后解析，扫描并保存所有相关的类并提供统一的访问入口。
 * <p>
 * 对配置文件进行查找、读取、解析
 *
 * @author eric
 * @since 2020/12/6 15:11
 */
public class GPBeanDefinitionReader {

    private List<String> registryBeanClasses = new ArrayList<String>();
    private Properties config = new Properties();

    /**
     * 固定配置文件中的key，相对于XML的规范
     */
    private final String CSAN_PACKAGE = "scanPackage";

    public GPBeanDefinitionReader(String... locations) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        doScanner(config.getProperty(CSAN_PACKAGE));

    }

    private void doScanner(String scanPackage) {
        String regex = "\\.";
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll(regex, "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                registryBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig() {
        return this.config;
    }

    /**
     * 把配置文件中扫描到的所有配置信息转换为GPBeanDefinition对象，以便于之后的Ioc操作
     *
     * @return
     */
    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> result = new ArrayList<GPBeanDefinition>();
        try {
            for (String className : registryBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }

                String lowerFirstCase = toLowerFirstCase(beanClass.getSimpleName());
                GPBeanDefinition beanDefinition = dpCreateBeanDefinition(lowerFirstCase, beanClass.getName());
                result.add(beanDefinition);

                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces) {
                    String lowerFirstCase2 = toLowerFirstCase(i.getName());
                    GPBeanDefinition beanDefinition2 = dpCreateBeanDefinition(lowerFirstCase2, beanClass.getName());
                    result.add(beanDefinition2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 把每一个配置信息解析成一个BeanDefinition
     *
     * @param factoryBeanName
     * @param beanClassName
     * @return
     */
    private GPBeanDefinition dpCreateBeanDefinition(String factoryBeanName, String beanClassName) {
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }

    /**
     * 将类名首字母改为小写
     * 为了简化程序逻辑，就不做其他判断了，了解就好
     *
     * @param simpleName
     * @return
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        /**
         * 因为大小写字母的ASCII码相差32
         * 而且大写字母的ASCII码要小于小写字母的ASCII码
         * 在Java中，对char做算数运算，实际上就是对ASCII码做算数运算
         */
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
