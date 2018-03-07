package cn.codingstar.offer.cache;

import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.concurrent.TimeoutException;

public class UseCase {

    public static void main(String[] args) {
        MemcacheManager manager = MemcacheManager.getInstance();
        try {
            manager.set("star",30,new String("Hello World"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            Object value = manager.get("star");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
