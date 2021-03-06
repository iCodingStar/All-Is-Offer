package cn.codingstar.offer.ioc;

import cn.codingstar.offer.ioc.beans.SimpleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Application.java
 * @time: 18-3-15 上午10:19
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Application {

    public static void main(String[] args) {
        // 创建Spring容器管理上下文
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        applicationContext.getEnvironment().setActiveProfiles("dev");
        // 获取对应类型的对象
        SimpleBean bean = applicationContext.getBean(SimpleBean.class);
        // 调用对象
        bean.print("Spring IOC is great !");
        // 关闭Spring容器
        applicationContext.close();
    }

}
