package org.wheat.tliaswebmanagement;


/**
 * 总结: ThreadLocal 是一个线程内部的数据存储器，每个线程内部都有自己的数据存储器，数据存储器中存储的数据是线程独享的
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message");

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Sub Message");
                System.out.println(Thread.currentThread().getName() + " : " + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

        local.remove();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());
    }
}
