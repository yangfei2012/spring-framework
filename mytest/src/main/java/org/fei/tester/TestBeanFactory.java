package org.fei.tester;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 需要把resource中的xml文件手动放到编译后的resource包中
 * (用main函数启动的方式可能需要打gradle包才能得到可运行包)
 */
public class TestBeanFactory {

    public static void main(String args[]) {
        String path = "test.xml";


        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:test.xml");

        BeanFactory container = (BeanFactory)beanRegistry;

        //BeanFactory container = new XmlBeanFactory(new ClassPathResource(path));

        TProvider provider = (TProvider)container.getBean("tProvider");

        provider.haha();
    }
}
