package thread;

import java.time.LocalDateTime;

public class demo3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start = " + LocalDateTime.now());
        Thread thread1=new Thread(()-> {
            try {
                Thread.sleep(1000);
                System.out.println("thread1 end = " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        thread1.setDaemon(true);
        thread1.start();
        thread1.join();

        Thread thread2=new Thread(()-> {
                //Thread.sleep(2000);
                System.out.println("thread2 end = " + LocalDateTime.now());
        });
        thread2.setDaemon(true);
        thread2.start();
        System.out.println("main end = " + LocalDateTime.now());
    }
}
