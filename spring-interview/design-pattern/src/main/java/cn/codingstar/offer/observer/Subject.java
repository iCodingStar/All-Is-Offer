package cn.codingstar.offer.observer;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Subject.java
 * @time: 18-4-16 上午10:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://www.cnblogs.com/liuzhen1995/p/5975352.html
 * @desc: 主题是一个接口，该接口规定了具体主题需要实现的方法，
 * 比如添加、删除观察者以及通知观察者更新数据的方法。
 */
public interface Subject {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();
}
