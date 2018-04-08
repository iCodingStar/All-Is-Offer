package cn.codingstar.leetcode.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: LRUCache.java
 * @time: 18-4-8 下午8:38
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class LRUCache {

    private int capacity = 2;

    private LinkedHashMap<Integer, Integer> map;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 构造一个容量为capacity的LRUCache
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }


    /**
     * 获取键为key的item值
     *
     * @param key
     * @return
     */
    public int get(int key) {
        lock.readLock().lock();
        int value = map.get(key);
        lock.readLock().unlock();
        return value;
    }

    /**
     * 增加键值对
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        lock.writeLock().lock();
        map.put(key, value);
        lock.writeLock().unlock();
    }

    /**
     * 查询是否存在包含键为key的item
     *
     * @param key
     * @return
     */
    public boolean containsKey(int key) {
        lock.readLock().lock();
        boolean isContains = map.containsKey(key);
        lock.readLock().unlock();
        return isContains;
    }

    /**
     * 删除键为key的item
     *
     * @param key
     */
    public void remove(int key) {
        lock.writeLock().lock();
        map.remove(key);
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(4, 3);
        System.out.println(cache.get(4));
    }
}
