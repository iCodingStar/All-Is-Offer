package cn.codingstar.offer.ioc.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: XmlBeanFactoryTest.java
 * @time: 18-3-23 下午5:03
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class XmlBeanFactoryTest {

    public static void main(String[] args) {
        // 1.创建IOC配置文件的抽象资源，这个资源包含了BeanDefinition的定义信息
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        // 2. 创建一个BeanFactory,这里使用DefaultListableBeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 3. 创建一个载入BeanDefinition的载入器，这里使用XmlBeanDefinitionReader载入XML文件，通过回调配置给BeanFactory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 4. 从定义好的资源位置读入配置信息，具体的解析过程由XmlBeanDefinitionReader来玩会才能
        reader.loadBeanDefinitions(resource);
    }
}
