package thread;

public class demo4 {
    int data=0;
    public static void main(String[] args) throws InterruptedException {
      for(int i=0;i<1000;i++){
          foo1();
      }
    }

    private static void foo1() throws InterruptedException {
        demo4 dd=new demo4();

        Thread thread1=new Thread(()->{
            for(int i=0;i<10;i++){
                dd.sub();
            }
            //System.out.println(" thread1 end" );
        });

        Thread thread2=new Thread(()->{
            for(int i=0;i<10;i++){
                dd.add();
            }
            //System.out.println(" thread2 end" );
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("data = " + dd.data);
    }

    public synchronized void add(){
        this.data++;
    }

    public void sub(){
        this.data--;
    }
}
