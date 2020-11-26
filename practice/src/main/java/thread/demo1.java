package thread;

public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        foo1();

    }

    public static void foo1() throws InterruptedException {
        Thread thread1=new Thread(()-> {
            try {
                Thread.sleep(1000*10);
                System.out.println("thread1 = " );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread task = haha" );
        });
        thread1.setName("my thread");
        thread1.start();
        //thread1.interrupt();
        Thread.sleep(10*1000);
        Thread.interrupted();
        System.out.println("thread2 = " );

    }
}
