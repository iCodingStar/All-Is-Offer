package cn.codingstar.offer.thread.pool;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ThreadPool.java
 * @time: 18-3-20 上午10:26
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 线程池接口
 */
public interface ThreadPool<Job extends Runnable> {

    // 执行一个job，这个job需要实现Runnable
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 增加工作者线程
    void addWorkers(int num);

    // 减少工作者线程
    void removeWorkers(int num);

    // 得到正在等待执行的任务数量
    int getJobSize();

}
