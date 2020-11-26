package thread;

public class demo2 {
    public static void main(String[] args) {
        Thread thread1=newThread(new SwimTask());
        thread1.setName("xiaoxiao");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

    }

    private static Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }

    private static class SwimTask implements Runnable {

        @Override
        public void run() {
            try{
                Thread.sleep(10000);
                System.out.println("Swimming ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class walkTask implements Runnable {

        @Override
        public void run() {
            System.out.println("walk=== ");
        }
    }
}
