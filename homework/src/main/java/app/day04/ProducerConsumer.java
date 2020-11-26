package app.day04;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        producerConsumer();
    }

    //1、用Java代码来编写生产者—消费者模式; wait(), notify()
    //例子：生产者往固定长度为10的List里面添加数据，当数据长度为10时则停止生产进入等待状态；数据长度不为10时继续生产
    // 消费者往list里面取数据，取完数据将该数据从list删除，当list为空时停止消费，list有值时继续消费
    public static void producerConsumer() {
        List data = new LinkedList();
        //生产者
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (data) {
                    while (true) {
                        while (data.size() == 10) {
                            try {
                                data.notifyAll();
                                System.out.println("数据已满进入消费者");
                                data.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        data.add((int) (Math.random() * 100));
                        System.out.println("producer data = " + data);
                    }

                }
            }
        });

        //消费者
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (data) {
                        while (data.size() == 0) {
                            try {
                                data.notifyAll();
                                System.out.println("数据已空，进入生产者");
                                data.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        data.remove(0);
                        System.out.println("consumer data = " + data);
                    }

                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
