package cn.codingstar.offer.observer;

import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SeekJobCenter.java
 * @time: 18-4-16 上午10:16
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class SeekJobCenter implements Subject {
    private String message;
    private boolean changed;
    private List<Observer> observers; //存放观察者的线性表

    /**
     * 添加一个观察者
     *
     * @param observer
     */
    @Override
    public void attachObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * 删除一个观察者
     *
     * @param observer
     */
    @Override
    public void detachObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        if (changed) {
            for (Observer observer : observers) {
                observer.hearTelephone(message);
            }
        }
    }

    public void setMessage(String message) {
        if (message != null || message.equals(this.message)) {
            this.changed = false;
        } else {
            this.message = message;
            this.changed = true;
        }
    }
}
