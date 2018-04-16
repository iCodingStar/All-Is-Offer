package cn.codingstar.offer.observer;

import java.io.File;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UniversityStudent.java
 * @time: 18-4-16 上午10:25
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class UniversityStudent implements Observer {

    private Subject subject;
    private File file;

    public UniversityStudent(Subject subject, String filename) {
        this.subject = subject;
        // 使当前实例成为subject所使用主题的观察者
        subject.attachObserver(this);
        file = new File(filename);
    }

    @Override
    public void hearTelephone(String message) {

    }
}
