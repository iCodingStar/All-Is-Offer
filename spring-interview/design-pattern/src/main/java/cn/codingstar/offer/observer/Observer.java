package cn.codingstar.offer.observer;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Observer.java
 * @time: 18-4-16 上午10:12
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 观察者是一个接口，该接口规定了具体观察者用来更新数据的方法。
 */
public interface Observer {

    void hearTelephone(String message);

}
