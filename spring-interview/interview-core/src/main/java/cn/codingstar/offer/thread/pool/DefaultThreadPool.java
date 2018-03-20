package cn.codingstar.offer.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: DefaultThreadPool.java
 * @time: 18-3-20 上午10:30
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    // 线程最大限制数
    private static final int MAX_WORKER_NUM = 10;

    // 线程默认的数量
    private static final int DEFAULT_WORKER_NUM = 5;

    // 线程最小的数量
    private static final int MIN_WORKER_NUM = 1;

    // 这是一个工作列表，会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();

    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    // 工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUM;

    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUM ? MAX_WORKER_NUM : num < MIN_WORKER_NUM ? MIN_WORKER_NUM : num;
        // 初始化工作线程
        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            // 添加一个工作，然后进行通知
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            // 限制新增的worker不能超过最大值
            if (num + this.workerNum > MAX_WORKER_NUM) {
                num = MAX_WORKER_NUM - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num > this.workerNum) {
                throw new IllegalArgumentException("Beyond workerNum ...");
            }
            // 按照给定的数量停止worker
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(num);
                if (workers.remove(worker)) {
                    worker.shutDown();
                    count++;
                }
            }
            this.workerNum -= num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "Thread-Pool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {
        // 是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            // 如果当前线程处于运行状态，则一直运行
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    // 如果工作者列表是空的，就阻塞
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对线程的中断操作
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出一个Job
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    // 执行job
                    job.run();
                }
            }

        }

        public void shutDown() {
            running = false;
        }
    }
}
