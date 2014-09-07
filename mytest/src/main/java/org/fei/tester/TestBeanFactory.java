package org.fei.tester;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 需要把resource中的xml文件手动放到编译后的resource包中
 * (用main函数启动的方式可能需要打gradle包才能得到可运行包)
 */
public class TestBeanFactory {

    public static void main(String args[]) {

        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

        /*
        // xml reader bind
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:test.xml");

        // code bind
        //bindViaCode(beanRegistry);

        BeanFactory container = (BeanFactory)beanRegistry;
        */

        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:test.xml");

        TProvider provider = (TProvider)container.getBean("tProvider");

        provider.haha();
    }

    public static BeanDefinitionRegistry bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition tProvider =
                new RootBeanDefinition(TProvider.class);
        AbstractBeanDefinition tlistener =
                new RootBeanDefinition(ATListener.class);

        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, tlistener);
        tProvider.setConstructorArgumentValues(argValues);

        /*
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("tListener", tlistener));
        tProvider.setPropertyValues(propertyValues);
        */

        registry.registerBeanDefinition("tProvider", tProvider);
        registry.registerBeanDefinition("tListener", tlistener);

        return registry;
    }
}
