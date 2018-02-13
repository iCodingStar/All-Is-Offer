package cn.codingstar.offer;

import cn.codingstar.offer.rpc.proxy.ChatAction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i++ < 100) {
            ChatAction act = new ChatAction();
            act.sayHello();
            Thread.sleep(3000);
        }
    }
}
